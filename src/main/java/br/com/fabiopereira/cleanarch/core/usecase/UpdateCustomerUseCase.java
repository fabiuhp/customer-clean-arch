package br.com.fabiopereira.cleanarch.core.usecase;

import br.com.fabiopereira.cleanarch.core.domain.Customer;

public interface UpdateCustomerUseCase {
    void update(Customer customer, String zipCode);
}
