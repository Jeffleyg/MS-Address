package com.Ms.endereco.consumers;

import com.Ms.endereco.constantes.RabbitmqConstantes;
import com.Ms.endereco.dto.EnderecoDTO;
import com.Ms.endereco.model.Endereco;
import com.Ms.endereco.repository.EnderecoRepository;
import com.Ms.endereco.service.ViaCepService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AddressConsumer {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @RabbitListener(queues = RabbitmqConstantes.FILA_ADDRESS)
    public void consumidor(Message message) {
        try {
            String jsonMessage = new String(message.getBody());
            EnderecoDTO enderecoDTO = objectMapper.readValue(jsonMessage, EnderecoDTO.class);
            Endereco enderecoCompleto = viaCepService.getEndereco(enderecoDTO.getCep());
            if (enderecoCompleto != null) {
                enderecoRepository.save(enderecoCompleto);
                System.out.println("Endereço salvo com sucesso: " + enderecoCompleto);
            } else {
                System.out.println("Não foi possível obter o endereço para o CEP: " + enderecoCompleto.getCep());
            }
        } catch (IOException e) {
            System.out.println("Erro ao processar mensagem: " + e.getMessage());
        }
    }

}
