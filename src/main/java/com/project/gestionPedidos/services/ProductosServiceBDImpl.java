package com.project.gestionPedidos.services;

import com.project.gestionPedidos.domain.Producto;
import com.project.gestionPedidos.persistance.entities.ProductoEntity;
import com.project.gestionPedidos.persistance.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Producto getProductoById(Long ProductoId) {
        Optional<ProductoEntity> optionalProducto = productosRepository.findById(ProductoId);
        Producto producto=new Producto();
        producto.setProductoId(optionalProducto.get().getProductoId());
        producto.setNombreProducto(optionalProducto.get().getNombreProducto());
        producto.setPrecioProducto(optionalProducto.get().getPrecioProducto());
        producto.setDescripcionProducto(optionalProducto.get().getDescripcionProducto());
        producto.setStock(optionalProducto.get().getStock());
        producto.setCategoriaId(optionalProducto.get().getCategoriaId());
        return producto;
    }

    @Override
    public Producto updateProducto(Producto producto) {
        ProductoEntity existeProducto=productosRepository.findById(producto.getProductoId()).get();
        ProductoEntity entidadSeteada=setEntidadProducto(existeProducto,producto);
        productosRepository.save(entidadSeteada);
        return producto;
    }

    @Override
    public void deleteProducto(Long ProductoId) {
        productosRepository.deleteById(ProductoId);
    }

    public ProductoEntity setEntidadProducto( ProductoEntity existeProducto,Producto producto){
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setProductoId(producto.getProductoId());
        productoEntity.setNombreProducto(producto.getNombreProducto());
        productoEntity.setPrecioProducto(producto.getPrecioProducto());
        productoEntity.setDescripcionProducto(producto.getDescripcionProducto());
        productoEntity.setStock(producto.getStock());
        productoEntity.setCategoriaId(producto.getCategoriaId());
        return productoEntity;
    }
}
