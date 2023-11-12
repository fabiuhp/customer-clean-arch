package br.com.fabiopereira.cleanarch.entrypoint.controller;

import br.com.fabiopereira.cleanarch.core.usecase.FindCustomerByIdUseCase;
import br.com.fabiopereira.cleanarch.core.usecase.InsertCustomerUsecase;
import br.com.fabiopereira.cleanarch.core.usecase.UpdateCustomerUseCase;
import br.com.fabiopereira.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import br.com.fabiopereira.cleanarch.entrypoint.controller.request.CustomerRequest;
import br.com.fabiopereira.cleanarch.entrypoint.controller.response.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private InsertCustomerUsecase insertCustomerUsecase;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;
    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        insertCustomerUsecase
                .insert(customerMapper
                        .toCustomer(customerRequest), customerRequest.zipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findBy(@PathVariable String id) {
        var customer = findCustomerByIdUseCase.find(id);
        return ResponseEntity.ok(customerMapper.toCostumerResponse(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerUseCase.update(customer, customerRequest.zipCode());
        return ResponseEntity.noContent().build();
    }

}
