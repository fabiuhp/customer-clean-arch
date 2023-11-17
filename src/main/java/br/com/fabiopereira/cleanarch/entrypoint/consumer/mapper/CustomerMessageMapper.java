package br.com.fabiopereira.cleanarch.entrypoint.consumer.mapper;

import br.com.fabiopereira.cleanarch.core.domain.Customer;
import br.com.fabiopereira.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {
    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
