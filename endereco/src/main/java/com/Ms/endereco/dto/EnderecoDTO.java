package com.Ms.endereco.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
//@JsonDeserialize
//@JsonSerialize
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO implements Serializable {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
