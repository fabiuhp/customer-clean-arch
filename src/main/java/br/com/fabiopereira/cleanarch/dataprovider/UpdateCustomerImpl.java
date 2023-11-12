package br.com.fabiopereira.cleanarch.dataprovider;

import br.com.fabiopereira.cleanarch.core.dataprovider.UpdateCustomer;
import br.com.fabiopereira.cleanarch.core.domain.Customer;
import br.com.fabiopereira.cleanarch.dataprovider.repository.CustomerRepository;
import br.com.fabiopereira.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerImpl implements UpdateCustomer {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        customerRepository.save(
                customerEntityMapper.toCustomerEntity(customer)
        );
    }
}
