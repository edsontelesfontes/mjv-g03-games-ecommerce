package com.mjv.fontesdosgames.Repository;

import com.mjv.fontesdosgames.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNome(String nome);
    List<Produto> findByNomeContainsIgnoreCase(String nome);
}
