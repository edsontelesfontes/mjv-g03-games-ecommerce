package com.mjv.fontesdosgames.Mapper;

import com.mjv.fontesdosgames.Model.Endereco;
import com.mjv.fontesdosgames.Recursos.EnderecoPostRequestBody;
import com.mjv.fontesdosgames.Recursos.EnderecoPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class EnderecoMapper {

    public static final EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    public abstract Endereco toEndereco(EnderecoPostRequestBody enderecoPostRequestBody);
    public abstract Endereco toEndereco(EnderecoPutRequestBody enderecoPutRequestBody);
}
