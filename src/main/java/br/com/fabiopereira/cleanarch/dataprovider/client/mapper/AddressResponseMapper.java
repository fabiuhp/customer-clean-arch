package br.com.fabiopereira.cleanarch.dataprovider.client.mapper;

import br.com.fabiopereira.cleanarch.core.domain.Address;
import br.com.fabiopereira.cleanarch.dataprovider.client.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AddressResponse addressResponse);
}
