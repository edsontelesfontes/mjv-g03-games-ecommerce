package com.mjv.fontesdosgames.Mapper;

import com.mjv.fontesdosgames.Model.Produto;
import com.mjv.fontesdosgames.Recursos.ProdutoPostRequestBody;
import com.mjv.fontesdosgames.Recursos.ProdutoPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ProdutoMapper {

    public static final ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    public abstract Produto toProduto(ProdutoPostRequestBody produtoPostRequestBody);
    public abstract Produto toProduto(ProdutoPutRequestBody produtoPutRequestBody);


}
