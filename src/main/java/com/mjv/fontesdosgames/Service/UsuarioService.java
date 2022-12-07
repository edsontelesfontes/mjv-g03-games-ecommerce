package com.mjv.fontesdosgames.Service;

import com.mjv.fontesdosgames.Mapper.EnderecoMapper;
import com.mjv.fontesdosgames.Mapper.UsuarioMapper;
import com.mjv.fontesdosgames.Model.Biblioteca;
import com.mjv.fontesdosgames.Model.Endereco;
import com.mjv.fontesdosgames.Model.Usuario;
import com.mjv.fontesdosgames.Recursos.EnderecoPostRequestBody;
import com.mjv.fontesdosgames.Recursos.EnderecoPutRequestBody;
import com.mjv.fontesdosgames.Recursos.UsuarioPostRequestBody;
import com.mjv.fontesdosgames.Recursos.UsuarioPutRequestBody;
import com.mjv.fontesdosgames.Repository.UsuarioRepository;
import com.mjv.fontesdosgames.Utils.BuscaCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {
@Autowired
private UsuarioRepository usuarioRepository;
//@Autowired
//private EnderecoService enderecoService;

@Autowired
private BibliotecaService bibliotecaService;
    public List<Usuario> listAll() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> findByName(String name) {
        return usuarioRepository.findByNome(name);
    }

    public List<Usuario> findByNameLikeIgnoreSensitivyCase(String name) {
        return usuarioRepository.findByNomeContainsIgnoreCase(name);
    }

    public Usuario findByIdOrThrowBadRequestException(long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario não encontrado !"));
    }

    public Usuario save(UsuarioPostRequestBody usuarioPostRequestBody) {
        if(usuarioPostRequestBody.getSenha().isBlank() || usuarioPostRequestBody.getSenha() == null || usuarioPostRequestBody.getSenha().length() < 5){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Por favor insira uma senha válida com no mínimo 5 digitos");
        }
        if(usuarioPostRequestBody.getCpf().isBlank() || usuarioPostRequestBody.getCpf() == null || usuarioPostRequestBody.getCpf().replaceAll("\\D","").length() < 11){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Digite um cpf válido !");
        }
        usuarioPostRequestBody.setCpf(usuarioPostRequestBody.getCpf().replaceAll("\\D",""));
        usuarioPostRequestBody.setDataDeRegistro(LocalDate.now());
        usuarioPostRequestBody.setBiblioteca(new Biblioteca());

        Endereco endereco = BuscaCep.buscarEndereco(usuarioPostRequestBody.getEndereco().getCep());
        endereco.setNumero(usuarioPostRequestBody.getEndereco().getNumero());

        usuarioPostRequestBody.setEndereco(endereco);

        return usuarioRepository.save(UsuarioMapper.INSTANCE.toUsuario(usuarioPostRequestBody));
    }
    public Usuario saveProduto(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public void replace(UsuarioPutRequestBody usuarioPutRequestBody) {
        Usuario saveUsuario = findByIdOrThrowBadRequestException(usuarioPutRequestBody.getId());
        Usuario usuario = UsuarioMapper.INSTANCE.toUsuario(usuarioPutRequestBody);

        usuario.setId(saveUsuario.getId());

        usuarioRepository.save(usuario);
    }

    public void delete(long id) {
        usuarioRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void addEndereco(long id, EnderecoPutRequestBody enderecoPutRequestBody) {
        Usuario savedUsuario = findByIdOrThrowBadRequestException(id);
        Endereco endereco = EnderecoMapper.INSTANCE.toEndereco(enderecoPutRequestBody);
        //enderecoService.findByIdOrThrowBadRequestException(enderecoPutRequestBody.getId());

        savedUsuario.setEndereco(endereco);

        usuarioRepository.save(savedUsuario);
    }

    public void addBiblioteca(long id, long idBiblioteca){
        Usuario savedUsuario = findByIdOrThrowBadRequestException(id);
        Biblioteca biblioteca = bibliotecaService.findByIdOrShouldThrowException(idBiblioteca);

        savedUsuario.setBiblioteca(biblioteca);

        usuarioRepository.save(savedUsuario);
    }
}
