package com.mjv.fontesdosgames.Service;

import com.mjv.fontesdosgames.Mapper.UsuarioMapper;
import com.mjv.fontesdosgames.Model.Endereco;
import com.mjv.fontesdosgames.Model.Usuario;
import com.mjv.fontesdosgames.Recursos.EnderecoPutRequestBody;
import com.mjv.fontesdosgames.Recursos.UsuarioPostRequestBody;
import com.mjv.fontesdosgames.Recursos.UsuarioPutRequestBody;
import com.mjv.fontesdosgames.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioService {
@Autowired
private UsuarioRepository usuarioRepository;
@Autowired
private EnderecoService enderecoService;
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
        Endereco endereco = enderecoService.findByIdOrThrowBadRequestException(enderecoPutRequestBody.getId());

        savedUsuario.setEndereco(endereco);

        usuarioRepository.save(savedUsuario);
    }
}
