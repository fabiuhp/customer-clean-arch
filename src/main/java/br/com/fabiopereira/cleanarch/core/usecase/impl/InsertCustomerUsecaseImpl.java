package br.com.fabiopereira.cleanarch.core.usecase.impl;

import br.com.fabiopereira.cleanarch.core.dataprovider.FindAddressByZipCode;
import br.com.fabiopereira.cleanarch.core.dataprovider.InsertCustomer;
import br.com.fabiopereira.cleanarch.core.dataprovider.SendCpfForValidation;
import br.com.fabiopereira.cleanarch.core.domain.Customer;
import br.com.fabiopereira.cleanarch.core.usecase.InsertCustomerUsecase;

public class InsertCustomerUsecaseImpl implements InsertCustomerUsecase {
    private final FindAddressByZipCode findAddressByZipCode;
    private final InsertCustomer insertCustomer;
    private final SendCpfForValidation sendCpfForValidation;
    
    public InsertCustomerUsecaseImpl(FindAddressByZipCode findAddressByZipCode, InsertCustomer insertCustomer, SendCpfForValidation sendCpfForValidation) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
        this.sendCpfForValidation = sendCpfForValidation;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);
        insertCustomer.insert(customer);
        sendCpfForValidation.send(customer.getCpf());
    }
}
