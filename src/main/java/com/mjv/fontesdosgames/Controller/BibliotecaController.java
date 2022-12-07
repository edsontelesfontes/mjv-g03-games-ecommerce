package com.mjv.fontesdosgames.Controller;

import com.mjv.fontesdosgames.Model.Biblioteca;
import com.mjv.fontesdosgames.Model.Endereco;
import com.mjv.fontesdosgames.Recursos.EnderecoPostRequestBody;
import com.mjv.fontesdosgames.Service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("biblioteca")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> findById(@PathVariable  long id){
        return ResponseEntity.ok(bibliotecaService.findByIdOrShouldThrowException(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Biblioteca>> findAll(){
        return ResponseEntity.ok((bibliotecaService.findAll()));
    }

    @PostMapping("/")
    public void save(@RequestBody Biblioteca biblioteca) {
        bibliotecaService.save(biblioteca);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable long id, @RequestParam(name = "pedido")  long idPedido){
        bibliotecaService.update(id, idPedido);
    }
}
//TODO
//loscalhost:8080/biblioteca/1?participante=1
//pesquisar sobre rest template -> para consumir o via cep