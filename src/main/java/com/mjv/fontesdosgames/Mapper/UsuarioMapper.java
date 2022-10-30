package com.mjv.fontesdosgames.Mapper;

import com.mjv.fontesdosgames.Model.Usuario;
import com.mjv.fontesdosgames.Recursos.UsuarioComPedido;
import com.mjv.fontesdosgames.Recursos.UsuarioPostRequestBody;
import com.mjv.fontesdosgames.Recursos.UsuarioPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {

    public static final UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    public abstract Usuario toUsuario(UsuarioPostRequestBody usuarioPostRequestBody);
    public abstract Usuario toUsuario(UsuarioPutRequestBody usuarioPutRequestBody);

    public abstract Usuario toUsuario(UsuarioComPedido usuarioComPedido);

}