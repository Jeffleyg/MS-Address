package com.Ms.endereco.app;

import com.Ms.endereco.model.Endereco;
import com.Ms.endereco.repository.EnderecoRepository;
import com.Ms.endereco.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private ViaCepService viaCepService;
    @Autowired
    private EnderecoRepository enderecoRepository;


    @GetMapping("/{cep}")
    public Endereco getEnderecoPorCep(@PathVariable String cep) throws IOException {
        Endereco endereco = viaCepService.getEndereco(cep);
        if (endereco != null) {
            enderecoRepository.save(endereco);
        }
        return endereco;
    }

    @GetMapping("/getAll")
    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }


}
