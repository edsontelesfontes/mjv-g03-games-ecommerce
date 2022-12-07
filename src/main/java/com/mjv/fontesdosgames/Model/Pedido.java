package com.mjv.fontesdosgames.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mjv.fontesdosgames.Enums.EnumStatusPagamento;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dataDaCompra", nullable = false)
    private LocalDateTime dataDaCompra;
    @Enumerated(value = EnumType.STRING)
    private EnumStatusPagamento enumStatusPagamento;
    @Column(name = "valortotalDaCompra", nullable = false)
    private Double valorTotalDaCompra;

    //@ManyToOne(cascade = CascadeType.ALL)

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Set<PedidoItem> pedidoItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    public LocalDateTime getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(LocalDateTime dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public EnumStatusPagamento getEnumStatusPagamento() {
        return enumStatusPagamento;
    }

    public void setEnumStatusPagamento(EnumStatusPagamento enumStatusPagamento) {
        this.enumStatusPagamento = enumStatusPagamento;
    }

    public Double getValorTotalDaCompra() {
        return valorTotalDaCompra;
    }

    public void setValorTotalDaCompra(Double valorTotalDaCompra) {
        this.valorTotalDaCompra = valorTotalDaCompra;
    }


//    public List<PedidoItem> getPedidoItems() {
//        return pedidoItems;
//    }
//
//    public void setPedidoItems(List<PedidoItem> pedidoItems) {
//        this.pedidoItems = pedidoItems;
//    }


    public Set<PedidoItem> getPedidoItems() {
        return pedidoItems;
    }

    public void setPedidoItems(Set<PedidoItem> pedidoItems) {
        this.pedidoItems = pedidoItems;
    }
}
