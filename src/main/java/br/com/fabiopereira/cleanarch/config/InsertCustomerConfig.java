package br.com.fabiopereira.cleanarch.config;

import br.com.fabiopereira.cleanarch.core.usecase.impl.InsertCustomerUsecaseImpl;
import br.com.fabiopereira.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import br.com.fabiopereira.cleanarch.dataprovider.InsertCustomerImpl;
import br.com.fabiopereira.cleanarch.dataprovider.SendCpfForValidationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {
    @Bean
    public InsertCustomerUsecaseImpl insertCustomerUsecase(
            FindAddressByZipCodeImpl findAddressByZipCode,
            InsertCustomerImpl insertCustomer,
            SendCpfForValidationImpl sendCpfForValidation) {
        return new InsertCustomerUsecaseImpl(findAddressByZipCode, insertCustomer, sendCpfForValidation);
    }
}
