package com.mjv.fontesdosgames.Model;

import javax.persistence.*;

//@Embeddable
//@Entity
//@Table(name = "tab_endereco")
@Embeddable

public class Endereco {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long Id;

    @Column(name = "logradouro",length = 50, nullable = false)
    private String logradouro;
    @Column(name = "cep",length = 10, nullable = false)
    private String cep;
    @Column(name = "numero",length = 6, nullable = false)

    private Integer numero;
    @Column(name = "localidade",length = 50, nullable = false)

    private String localidade;
    @Column(name = "bairro",length = 30, nullable = false)
    private String bairro;
    @Column(name = "complemento",length = 50, nullable = true)

    private String complemento;
    @Column(name = "uf", length = 2, nullable = false)

    private String uf;


//    public Long getId() {
//        return Id;
//    }
//
//    public void setId(Long id) {
//        Id = id;
//    }


    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
