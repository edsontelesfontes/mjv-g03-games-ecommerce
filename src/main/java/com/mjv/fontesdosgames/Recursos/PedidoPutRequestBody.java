package com.mjv.fontesdosgames.Recursos;

import com.mjv.fontesdosgames.Enums.EnumStatusPagamento;
import com.mjv.fontesdosgames.Model.PedidoItem;
import com.mjv.fontesdosgames.Model.Produto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoPutRequestBody {

    private Long id;
    private LocalDateTime dataDaCompra;
    private EnumStatusPagamento enumStatusPagamento;
    private Double valorTotalDaCompra;

    private List<Produto> produto = new ArrayList<>();
    private List<PedidoItem> pedidoItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    public List<PedidoItem> getPedidoItems() {
        return pedidoItems;
    }

}
