package com.mjv.fontesdosgames.Controller;

import com.mjv.fontesdosgames.Model.Endereco;
import com.mjv.fontesdosgames.Recursos.EnderecoPostRequestBody;
import com.mjv.fontesdosgames.Recursos.EnderecoPutRequestBody;
import com.mjv.fontesdosgames.Service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/")
    public ResponseEntity<List<Endereco>> findAll() {
        return ResponseEntity.ok(enderecoService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping("/")
    public Endereco save(@RequestBody EnderecoPostRequestBody enderecoPostRequestBody) {
        return enderecoService.save(enderecoPostRequestBody);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        enderecoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/")
    public ResponseEntity<Endereco> replace(@RequestBody EnderecoPutRequestBody enderecoPutRequestBody){
        enderecoService.replace(enderecoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
