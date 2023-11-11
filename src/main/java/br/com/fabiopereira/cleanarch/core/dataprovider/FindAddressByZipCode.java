package br.com.fabiopereira.cleanarch.core.dataprovider;

import br.com.fabiopereira.cleanarch.core.domain.Address;

public interface FindAddressByZipCode {
    Address find(final String zipCode);
}
