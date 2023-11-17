package br.com.fabiopereira.cleanarch.entrypoint.consumer;

import br.com.fabiopereira.cleanarch.core.usecase.UpdateCustomerUseCase;
import br.com.fabiopereira.cleanarch.entrypoint.consumer.mapper.CustomerMessageMapper;
import br.com.fabiopereira.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {
    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;
    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "fabiuhp")
    public void receive(CustomerMessage customerMessage) {
        updateCustomerUseCase
                .update(customerMessageMapper
                                .toCustomer(
                                        customerMessage),
                        customerMessage.getZipCode());
    }
}
