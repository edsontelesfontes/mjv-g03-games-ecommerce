package com.mjv.fontesdosgames.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

    @Column(name = "logradouro",length = 50, nullable = false)
    private String lougradouro;
    @Column(name = "cep",length = 10, nullable = false)
    private String cep;
    @Column(name = "numero",length = 6, nullable = false)

    private Integer numero;
    @Column(name = "cidade",length = 50, nullable = false)

    private String cidade;
    @Column(name = "bairro",length = 30, nullable = false)
    private String bairro;
    @Column(name = "complemento",length = 50, nullable = true)

    private String complemento;
    @Column(name = "uf", length = 2, nullable = false)

    private String uf;
    @Column(name = "pais",length = 15, nullable = false)

    private String pais;


    public String getLougradouro() {
        return lougradouro;
    }

    public void setLougradouro(String lougradouro) {
        this.lougradouro = lougradouro;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
