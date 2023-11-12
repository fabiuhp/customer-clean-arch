package br.com.fabiopereira.cleanarch.config;

import br.com.fabiopereira.cleanarch.core.usecase.impl.DeleteCustomerByIdUseCaseImpl;
import br.com.fabiopereira.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import br.com.fabiopereira.cleanarch.dataprovider.DeleteCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {
    @Bean
    public DeleteCustomerByIdUseCaseImpl deleteCustomerByIdUseCase(
            FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
            DeleteCustomerByIdImpl deleteCustomerById
    ) {
        return new DeleteCustomerByIdUseCaseImpl(findCustomerByIdUseCase, deleteCustomerById);
    }
}
