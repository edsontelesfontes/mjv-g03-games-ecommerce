package com.mjv.fontesdosgames.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "nome", length = 100, nullable = false)

    private String nome;
    @Column(name = "senha", length = 15, nullable = false)
    private String senha;
    @Column(name = "dataDeRegistro", nullable = true)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeRegistro;
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(length = 11, nullable = false,unique = true)
    private String cpf;
    //@Embedded

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "endereco_id")
    @Embedded
    private Endereco endereco;


    @OneToMany(cascade =CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private List<Pedido> pedidoList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "biblioteca_id")
    private Biblioteca biblioteca;

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

//    public void setPedidoList(List<Pedido> pedidoList) {
//        this.pedidoList = pedidoList;
//    }


    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}
