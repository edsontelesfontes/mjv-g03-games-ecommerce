package com.mjv.fontesdosgames.Service;

import com.mjv.fontesdosgames.Model.Pedido;
import com.mjv.fontesdosgames.Model.PedidoItem;
import com.mjv.fontesdosgames.Model.Produto;
import com.mjv.fontesdosgames.Repository.PedidoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PedidoItemService {

    @Autowired
    private PedidoItemRepository pedidoItemRepository;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private PedidoService pedidoService;
    public PedidoItem findByIdOrThrowBadRequestException(Long itemId) {
        return pedidoItemRepository.findById(itemId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Falta algo no corpo da página ou o usuário não encontrar"));
    }

    public List<PedidoItem> findAll() {
        return pedidoItemRepository.findAll();
    }

    public void saveItem(PedidoItem item){
        pedidoItemRepository.save(item);
    }

    public void save(long pedidoId, long produtoId) {
        Pedido pedido = pedidoService.findOrderByIdOrThrowException(pedidoId);
        Produto produto = produtoService.findByIdOrThrowBadRequestException(produtoId);

        PedidoItem pedidoItem = new PedidoItem();
        pedidoItem.setProduto(produto);

        pedido.getPedidoItems().add(pedidoItem);

        saveItem(pedidoItem);

        pedidoService.saveItem(pedido);

    }

    public void delete(long itemId){
        pedidoService.delete(itemId);
    }

}
