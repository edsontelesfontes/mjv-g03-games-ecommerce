package com.mjv.fontesdosgames.Service;

import com.mjv.fontesdosgames.Enums.EnumStatusPagamento;
import com.mjv.fontesdosgames.Model.Biblioteca;
import com.mjv.fontesdosgames.Model.Pedido;
import com.mjv.fontesdosgames.Model.Produto;
import com.mjv.fontesdosgames.Repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BibliotecaService {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @Autowired
    private ProdutoService produtoService;


    public Biblioteca findByIdOrShouldThrowException(Long id) {
        return bibliotecaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Biblioteca de jogos não encontrada"));
    }

    public List<Biblioteca> findAll() {
        return bibliotecaRepository.findAll();
    }

    public void save(Biblioteca biblioteca){
         bibliotecaRepository.save(biblioteca);
    }

    public void update(long idBiblioteca, long idPedido){
        Pedido pedido = pedidoService.findOrderByIdOrThrowException(idPedido);
        Biblioteca biblioteca = findByIdOrShouldThrowException(idBiblioteca);

        if(pedido.getEnumStatusPagamento().equals(EnumStatusPagamento.CONFIRMADO)){
           biblioteca.setJogos(pedido.getPedidoItems().stream().map(x -> x.getProduto().getNome()).collect(Collectors.toSet()));

            bibliotecaRepository.save(biblioteca);
        }
    }

}
