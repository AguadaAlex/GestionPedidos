package com.project.gestionPedidos.services;

import com.project.gestionPedidos.domain.Producto;
import com.project.gestionPedidos.persistance.entities.ProductoEntity;
import com.project.gestionPedidos.persistance.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("BD")
@ConditionalOnProperty(value = "productos.estrategia",havingValue = "EN_BD")
public class ProductosServiceBDImpl implements ProductoService{
    @Autowired
    private ProductosRepository productosRepository;
    @Override
    public List<Producto> getProductos() {
        List<ProductoEntity> productoEntities=productosRepository.findAll();
        List<Producto> productos=new ArrayList<>();
        for (ProductoEntity productoEntity : productoEntities){
            Producto producto = new Producto();
            producto.setProductoId(productoEntity.getProductoId());
            producto.setNombreProducto(productoEntity.getNombreProducto());
            producto.setPrecioProducto(productoEntity.getPrecioProducto());
            producto.setDescripcionProducto(productoEntity.getDescripcionProducto());
            producto.setStock(productoEntity.getStock());
            producto.setCategoriaId(productoEntity.getCategoriaId());
            productos.add(producto);
        }

        return productos;
    }

    @Override
    public void saveProducto(Producto producto) {
        ProductoEntity productoEntity=new ProductoEntity();
        System.out.println(producto);
        productoEntity.setNombreProducto(producto.getNombreProducto());
        productoEntity.setPrecioProducto(producto.getPrecioProducto());
        productoEntity.setDescripcionProducto(producto.getDescripcionProducto());
        productoEntity.setStock(producto.getStock());
        productoEntity.setCategoriaId(producto.getCategoriaId());
        productosRepository.save(productoEntity);

    }
}
