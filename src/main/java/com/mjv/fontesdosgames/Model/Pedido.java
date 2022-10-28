package com.mjv.fontesdosgames.Model;

import com.mjv.fontesdosgames.Enums.EnumStatusPagamento;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "dataDaCompra", nullable = false)
    private LocalDateTime dataDaCompra;
    @Enumerated(value = EnumType.STRING)
    private EnumStatusPagamento enumStatusPagamento;
    @Column(name = "valortotalDaCompra", nullable = false)
    private Double valorTotalDaCompra;

    //@ManyToOne(cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_pedido_id")
    private List<ItemsDoPedido> itemsDoPedido = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public List<ItemsDoPedido> getItemsDoPedido() {
        return itemsDoPedido;
    }
}
