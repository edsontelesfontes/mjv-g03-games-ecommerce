package com.mjv.fontesdosgames.Recursos;

import com.mjv.fontesdosgames.Model.Endereco;
import com.mjv.fontesdosgames.Model.Pedido;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioComPedido {
    private Long Id;
    private String nome;
    private String senha;
    private LocalDate dataDeRegistro;
    private String email;
    private Endereco endereco;
    private List<Pedido> pedidoList = new ArrayList<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

}
