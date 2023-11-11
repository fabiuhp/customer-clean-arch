package br.com.fabiopereira.cleanarch.core.usecase.impl;

import br.com.fabiopereira.cleanarch.core.dataprovider.FindAddressByZipCode;
import br.com.fabiopereira.cleanarch.core.dataprovider.InsertCustomer;
import br.com.fabiopereira.cleanarch.core.domain.Customer;
import br.com.fabiopereira.cleanarch.core.usecase.InsertCustomerUsecase;

public class InsertCustomerUsecaseImpl implements InsertCustomerUsecase {
    private final FindAddressByZipCode findAddressByZipCode;
    private final InsertCustomer insertCustomer;
    
    public InsertCustomerUsecaseImpl(FindAddressByZipCode findAddressByZipCode, InsertCustomer insertCustomer) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);
        insertCustomer.insert(customer);
    }
}
