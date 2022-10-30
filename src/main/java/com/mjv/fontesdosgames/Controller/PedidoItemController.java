package com.mjv.fontesdosgames.Controller;

import com.mjv.fontesdosgames.Model.PedidoItem;
import com.mjv.fontesdosgames.Service.PedidoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
public class PedidoItemController {

    @Autowired
    private PedidoItemService pedidoItemService;

    @GetMapping("/")
    public List<PedidoItem> findAll(){
        return pedidoItemService.findAll();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<PedidoItem> findById(@PathVariable long id) {
        return ResponseEntity.ok(pedidoItemService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping("/")
    public ResponseEntity<Void> save(@RequestParam(name = "pedidoId") long pedidoId, @RequestParam(name = "produtoId") long produtoId) {
        pedidoItemService.save(pedidoId, produtoId);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> delete(@PathVariable long idItem){
        pedidoItemService.delete(idItem);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    }
