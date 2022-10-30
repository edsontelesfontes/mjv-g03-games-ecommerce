package com.mjv.fontesdosgames.Controller;

import com.mjv.fontesdosgames.Model.Produto;
import com.mjv.fontesdosgames.Recursos.ProdutoPostRequestBody;
import com.mjv.fontesdosgames.Recursos.ProdutoPutRequestBody;
import com.mjv.fontesdosgames.Service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "jogos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable long id) {
        return ResponseEntity.ok(produtoService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/filtro")
    public ResponseEntity<List<Produto>> findByName(@RequestParam(name = "nome") String name) {
        return ResponseEntity.ok(produtoService.findByName(name));
    }

    @GetMapping(path = "/filtro/like")
    public ResponseEntity<List<Produto>> findByNameLike(@RequestParam(name = "nome") String name) {
        return ResponseEntity.ok(produtoService.findByNameLikeIgnoreSensitivyCase(name));
    }

    @PostMapping("/")
    public ResponseEntity<Produto> save(@RequestBody ProdutoPostRequestBody produtoPostRequestBody) {

        return ResponseEntity.ok(produtoService.save(produtoPostRequestBody));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        produtoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/")
    public ResponseEntity<Produto> replace(@RequestBody ProdutoPutRequestBody produtoPutRequestBody) {
        produtoService.replace(produtoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/atualizar")
    public ResponseEntity<Produto> atualizar(@RequestParam(name = "id") Long id,
                                              @RequestParam(name = "nome", required = false) String nome,
                                              @RequestParam(name = "descricao", required = false) String descricao,
                                              @RequestParam(name = "preco", required = false) Double preco,
                                              @RequestParam(name = "desenvolvedora", required = false) String desenvolvedora){

        produtoService.atualizarProduto(id, nome,descricao, preco, desenvolvedora);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
