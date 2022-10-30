package com.mjv.fontesdosgames.Recursos;

import com.mjv.fontesdosgames.Model.Endereco;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;

public class UsuarioPostRequestBody {
    private String nome;
    private String senha;
    private LocalDate dataDeRegistro;
    private String email;
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(LocalDate dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
