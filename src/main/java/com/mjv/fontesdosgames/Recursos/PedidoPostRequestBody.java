package com.mjv.fontesdosgames.Recursos;

import com.mjv.fontesdosgames.Enums.EnumStatusPagamento;
import com.mjv.fontesdosgames.Model.Produto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoPostRequestBody {

    private LocalDateTime dataDaCompra;
    private EnumStatusPagamento enumStatusPagamento;
    private Double valorTotalDaCompra;

    private List<Produto> produto = new ArrayList<>();

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
}
