package com.mjv.fontesdosgames.Controller;


import com.mjv.fontesdosgames.Model.Usuario;
import com.mjv.fontesdosgames.Recursos.EnderecoPutRequestBody;
import com.mjv.fontesdosgames.Recursos.UsuarioPostRequestBody;
import com.mjv.fontesdosgames.Recursos.UsuarioPutRequestBody;
import com.mjv.fontesdosgames.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable long id) {
        return ResponseEntity.ok(usuarioService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/filtro")
    public ResponseEntity<List<Usuario>> findByName(@RequestParam(name = "nome") String name) {
        return ResponseEntity.ok(usuarioService.findByName(name));
    }

    @GetMapping(path = "/filtro/like")
    public ResponseEntity<List<Usuario>> findByNameLike(@RequestParam(name = "nome") String name) {
        return ResponseEntity.ok(usuarioService.findByNameLikeIgnoreSensitivyCase(name));
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> save (@RequestBody UsuarioPostRequestBody usuarioPostRequestBody){
        return ResponseEntity.ok(usuarioService.save(usuarioPostRequestBody));
    }

    @PutMapping("/")
    public ResponseEntity<Usuario> replace (@RequestBody UsuarioPutRequestBody usuarioPutRequestBody){
        usuarioService.replace(usuarioPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/")
    public ResponseEntity<Usuario> delete (@PathVariable long id ){
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> addEndereco(@PathVariable long id, @RequestBody EnderecoPutRequestBody enderecoPutRequestBody){
        usuarioService.addEndereco(id, enderecoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/biblioteca/{id}")
    public ResponseEntity<Usuario> addBiblioteca(@PathVariable long id, @RequestParam(name = "biblioteca") long idBiblioteca){
        usuarioService.addBiblioteca(id, idBiblioteca);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
