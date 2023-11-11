package br.com.fabiopereira.cleanarch.dataprovider.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.fabiopereira.cleanarch.dataprovider.client.response.AddressResponse;

@FeignClient(
    name = "FindAddressByZipCodeClient",
    url = "${fabio.client.address.url}"
)
public interface FindAddressByZipCodeClient {
    @GetMapping("/{zipCode}")
    AddressResponse find(@PathVariable String zipCode);
}
