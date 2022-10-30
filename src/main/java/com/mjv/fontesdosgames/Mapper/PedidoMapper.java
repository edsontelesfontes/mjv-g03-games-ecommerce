package com.mjv.fontesdosgames.Mapper;

import com.mjv.fontesdosgames.Model.Pedido;
import com.mjv.fontesdosgames.Recursos.PedidoPostRequestBody;
import com.mjv.fontesdosgames.Recursos.PedidoPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PedidoMapper {

    public static final PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    public abstract Pedido toPedido(PedidoPostRequestBody pedidoPostRequestBody);

    public abstract Pedido toPedido(PedidoPutRequestBody pedidoPutRequestBody);




}
