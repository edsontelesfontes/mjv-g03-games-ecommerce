package com.mjv.fontesdosgames.Service;

import com.mjv.fontesdosgames.Enums.EnumStatusPagamento;
import com.mjv.fontesdosgames.Model.Usuario;
import com.mjv.fontesdosgames.Recursos.UsuarioComPedido;
import com.mjv.fontesdosgames.Recursos.UsuarioPutRequestBody;
import com.mjv.fontesdosgames.Mapper.PedidoMapper;
import com.mjv.fontesdosgames.Model.Pedido;
import com.mjv.fontesdosgames.Model.PedidoItem;
import com.mjv.fontesdosgames.Recursos.PedidoPostRequestBody;
import com.mjv.fontesdosgames.Repository.PedidoItemRepository;
import com.mjv.fontesdosgames.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
   // private PedidoItemService pedidoItemService;
    private PedidoItemRepository pedidoItemRepository;

    @Autowired
    private UsuarioService usuarioService;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }


    public Pedido findOrderByIdOrThrowException(long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pedido não encontrado"));
    }

    public Pedido saveItem(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido save(PedidoPostRequestBody pedidoPostRequestBody) {
        return pedidoRepository.save(PedidoMapper.INSTANCE.toPedido(pedidoPostRequestBody));
    }

    public void delete(long id) {
        pedidoRepository.delete(findOrderByIdOrThrowException(id));
    }

    public void novoPedido(Long usuarioId){
        Pedido pedido = new Pedido();
        pedido.setValorTotalDaCompra(0.0);
        pedido.setDataDaCompra(LocalDateTime.now());
        pedido.setEnumStatusPagamento(EnumStatusPagamento.PENDENTE);

        Usuario usuario = usuarioService.findByIdOrThrowBadRequestException(usuarioId);

        usuario.getPedidoList().add(pedido);

        usuarioService.saveProduto(usuario);
    }

    public Pedido addItem(Long id, Long itemId) {
        PedidoItem pedidoItem = pedidoItemRepository.findById(itemId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        Pedido pedido = findOrderByIdOrThrowException(id);

        pedido.getPedidoItems().add(pedidoItem);

        return pedidoRepository.save(pedido);
    }

    public Pedido removeItem(long id, long itemId) {
        Pedido pedido = findOrderByIdOrThrowException(id);
        PedidoItem pedidoItem = pedidoItemRepository.findById(itemId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));;


        pedido.getPedidoItems().remove(pedidoItem);

        return pedidoRepository.save(pedido);
    }
}
