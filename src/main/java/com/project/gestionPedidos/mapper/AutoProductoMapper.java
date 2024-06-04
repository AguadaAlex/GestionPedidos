package com.project.gestionPedidos.mapper;

import com.project.gestionPedidos.domain.Producto;
import com.project.gestionPedidos.persistance.entities.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoProductoMapper {
    AutoProductoMapper MAPPER= Mappers.getMapper(AutoProductoMapper.class);
    Producto MapToProductoDomain(ProductoEntity productoEntity);
    ProductoEntity MapToProductoEntity(Producto producto);
}
