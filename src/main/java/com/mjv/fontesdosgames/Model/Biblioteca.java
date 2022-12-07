package com.mjv.fontesdosgames.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "biblioteca")
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
//    @CollectionTable(
//            name = "tab_candidato_competencia",
//            joinColumns=@JoinColumn(name = "candidato_id", referencedColumnName = "id")
//    )
    @Column(name="jogos")
    private Set<String> jogos = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<String> getJogos() {
        return jogos;
    }

    public void setJogos(Set<String> jogos) {
        this.jogos = jogos;
    }


    //    @OneToMany(cascade =CascadeType.ALL)
//    @JoinColumn(name = "pedido_id")
//    private Set<Pedido> pedido = new HashSet<>();
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "produtoId")
//    private Set<Produto> produtos = new HashSet<>();

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//
//    public void setPedido(Set<Pedido> pedido) {
//        this.pedido = pedido;
//    }
//
////    public Pedido getPedido() {
////        return pedido;
////    }
////
////    public void setPedido(Pedido pedido) {
////        this.pedido = pedido;
////    }
//
//    public Set<Produto> getProdutos() {
//        return produtos;
//    }
//
//    public void setProdutos(Set<Produto> produtos) {
//        this.produtos = produtos;
//    }

}
