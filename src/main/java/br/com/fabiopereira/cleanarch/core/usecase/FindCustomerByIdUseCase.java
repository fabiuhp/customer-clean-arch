package br.com.fabiopereira.cleanarch.core.usecase;

import br.com.fabiopereira.cleanarch.core.domain.Customer;

public interface FindCustomerByIdUseCase {
    Customer find(final String id);
}
