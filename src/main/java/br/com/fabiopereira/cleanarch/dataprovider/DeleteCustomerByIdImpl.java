package br.com.fabiopereira.cleanarch.dataprovider;

import br.com.fabiopereira.cleanarch.core.dataprovider.DeleteCustomerById;
import br.com.fabiopereira.cleanarch.dataprovider.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdImpl implements DeleteCustomerById {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
