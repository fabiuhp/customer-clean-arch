package br.com.fabiopereira.cleanarch.entrypoint.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private String name;
    private String cpf;
    private boolean isValidCpf;
    private AddressResponse address;
}
