package com.project.gestionPedidos.mapper;

import com.project.gestionPedidos.domain.Producto;
import com.project.gestionPedidos.persistance.entities.ProductoEntity;
import jakarta.persistence.Column;

public class ProductoMapper {
    //CONVERTIR PRODUCTO JPA ENTITY A PRODUCTO DOMAIN
    public static Producto MapToProductoDomain(ProductoEntity productoEntity){
        Producto producto=new Producto(
                productoEntity.getProductoId(),
                productoEntity.getNombreProducto(),
                productoEntity.getPrecioProducto(),
                productoEntity.getDescripcionProducto(),
                productoEntity.getStock(),
                productoEntity.getCategoriaId());
        return producto;
    }
    //CONVERTIR PRODUCTO DOMAIN A PRODUCTO JPA ENTITY
    public static ProductoEntity MapToProductoEntity(Producto producto){
        ProductoEntity productoEntity=new ProductoEntity(
                producto.getProductoId(),
                producto.getNombreProducto(),
                producto.getPrecioProducto(),
                producto.getDescripcionProducto(),
                producto.getStock(),
                producto.getCategoriaId()
        );
        return productoEntity;
    }


}
