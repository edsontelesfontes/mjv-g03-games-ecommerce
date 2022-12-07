package com.mjv.fontesdosgames.Controller;

import com.mjv.fontesdosgames.Model.Pedido;
import com.mjv.fontesdosgames.Model.Usuario;
import com.mjv.fontesdosgames.Recursos.PedidoPostRequestBody;
import com.mjv.fontesdosgames.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/")
    public ResponseEntity<List<Pedido>> findAllOrder(){
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findOrderById(@PathVariable long id ){
        return ResponseEntity.ok((pedidoService.findOrderByIdOrThrowException(id)));
    }

    @PostMapping("/")
    public ResponseEntity<Pedido> save(@RequestBody PedidoPostRequestBody pedidoPostRequestBody){
        return ResponseEntity.ok(pedidoService.save(pedidoPostRequestBody));
    }

    @PostMapping("/novopedido")
    public ResponseEntity<Void> saveUsuarioPedido(@RequestParam(name = "idUsuario") long idUsuario){
        pedidoService.novoPedido(idUsuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        pedidoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}/gerarpedido")
    public ResponseEntity<Pedido> addItemPedido(@PathVariable("id") long id, @RequestParam("itemId") long itemId){
        return ResponseEntity.ok(pedidoService.addItem(id, itemId));
    }

    @PatchMapping("/pedidoStatus/{id}")
    public ResponseEntity<Pedido> alterarStatusPagamento(@PathVariable Long id, @RequestParam("status") String statusPagamento){
        return ResponseEntity.ok(pedidoService.alterarStatusPagamento(id, statusPagamento));
    }

    @PatchMapping("/{id}/removeritem")
    public ResponseEntity<Pedido> removerProduto(@PathVariable long id, @RequestParam ("itemId") long itemId){
        return ResponseEntity.ok(pedidoService.removeItem(id, itemId));
    }
}
