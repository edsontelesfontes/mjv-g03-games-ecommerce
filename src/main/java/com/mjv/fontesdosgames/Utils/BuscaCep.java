package com.mjv.fontesdosgames.Utils;

import com.mjv.fontesdosgames.Model.Endereco;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BuscaCep {

    public static Endereco buscarEndereco(String cep){
        return new RestTemplate().getForEntity("https://viacep.com.br/ws/"+cep+"/json/", Endereco.class).getBody();
    }
}
