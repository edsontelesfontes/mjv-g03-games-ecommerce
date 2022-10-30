package com.mjv.fontesdosgames.Repository;

import com.mjv.fontesdosgames.Model.Endereco;
import com.mjv.fontesdosgames.Model.Produto;
import com.mjv.fontesdosgames.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    List<Usuario> findByNome(String nome);
    List<Usuario> findByNomeContainsIgnoreCase(String nome);

}
