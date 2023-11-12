package br.com.fabiopereira.cleanarch.config;

import br.com.fabiopereira.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import br.com.fabiopereira.cleanarch.core.usecase.impl.UpdateCustomerUseCaseImpl;
import br.com.fabiopereira.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import br.com.fabiopereira.cleanarch.dataprovider.UpdateCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {
    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(
            FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
            FindAddressByZipCodeImpl findAddressByZipCode,
            UpdateCustomerImpl updateCustomer
    ) {
        return new UpdateCustomerUseCaseImpl(findCustomerByIdUseCase, findAddressByZipCode, updateCustomer);
    }
}
