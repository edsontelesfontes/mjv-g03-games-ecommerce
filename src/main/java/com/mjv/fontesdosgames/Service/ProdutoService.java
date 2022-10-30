package com.mjv.fontesdosgames.Service;

import com.mjv.fontesdosgames.Mapper.ProdutoMapper;
import com.mjv.fontesdosgames.Model.Produto;
import com.mjv.fontesdosgames.Recursos.ProdutoPostRequestBody;
import com.mjv.fontesdosgames.Recursos.ProdutoPutRequestBody;
import com.mjv.fontesdosgames.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
    public List<Produto> findByName(String name) {
        return produtoRepository.findByNome(name);
    }
    public List<Produto> findByNameLikeIgnoreSensitivyCase(String name) {
        return produtoRepository.findByNomeContainsIgnoreCase(name);
    }
    public Produto findByIdOrThrowBadRequestException(long id){
    return produtoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Jogo não encontrado !"));
    }

    public Produto save(ProdutoPostRequestBody produtoPostRequestBody) {
        return produtoRepository.save(ProdutoMapper.INSTANCE.toProduto(produtoPostRequestBody));
    }

    public void delete(long id){
         produtoRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(ProdutoPutRequestBody produtoPutRequestBody) {
        Produto saveProduto = findByIdOrThrowBadRequestException(produtoPutRequestBody.getId());
        Produto produto = ProdutoMapper.INSTANCE.toProduto(produtoPutRequestBody);

        produto.setId(saveProduto.getId());

        produtoRepository.save(produto);
    }

    public void atualizarProduto(Long id, String nome, String descricao, Double preco, String desenvolvedora) {
    Produto produto = findByIdOrThrowBadRequestException(id);

    if(nome != null){
        produto.setNome(nome);
    }
    if(descricao != null){
        produto.setDescricao(descricao);
    }
    if (preco != null){
        produto.setPreco(preco);
    }
    if(desenvolvedora != null){
        produto.setDesenvolvedora(desenvolvedora);
    }
    produtoRepository.save(produto);

    }
}
