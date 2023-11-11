package br.com.fabiopereira.cleanarch.core.usecase;

import br.com.fabiopereira.cleanarch.core.domain.Customer;

public interface InsertCustomerUsecase {
    void insert(Customer customer, String zipCode);
}
