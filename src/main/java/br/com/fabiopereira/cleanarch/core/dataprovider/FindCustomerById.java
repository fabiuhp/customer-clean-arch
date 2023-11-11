package br.com.fabiopereira.cleanarch.core.dataprovider;

import br.com.fabiopereira.cleanarch.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerById {
    Optional<Customer> find(final String id);
}
