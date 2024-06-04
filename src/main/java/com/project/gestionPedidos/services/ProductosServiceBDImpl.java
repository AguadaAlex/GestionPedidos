package com.project.gestionPedidos.services;

import com.project.gestionPedidos.domain.Producto;
import com.project.gestionPedidos.mapper.AutoProductoMapper;
import com.project.gestionPedidos.mapper.ProductoMapper;
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
            //productos.add(ProductoMapper.MapToProductoDomain(productoEntity));
            productos.add(AutoProductoMapper.MAPPER.MapToProductoDomain(productoEntity));
        }

        return productos;
    }

    @Override
    public void saveProducto(Producto producto) {
        System.out.println(producto);
        //productosRepository.save(ProductoMapper.MapToProductoEntity(producto));
        productosRepository.save(AutoProductoMapper.MAPPER.MapToProductoEntity(producto));

    }

    @Override
    public Producto getProductoById(Long ProductoId) {
        Optional<ProductoEntity> optionalProducto = productosRepository.findById(ProductoId);
        //return ProductoMapper.MapToProductoDomain(optionalProducto.get());
        return AutoProductoMapper.MAPPER.MapToProductoDomain(optionalProducto.get());
    }

    @Override
    public Producto updateProducto(Producto producto) {
        ProductoEntity existeProducto=productosRepository.findById(producto.getProductoId()).get();
        existeProducto.setNombreProducto(producto.getNombreProducto());
        existeProducto.setPrecioProducto(producto.getPrecioProducto());
        existeProducto.setDescripcionProducto(producto.getDescripcionProducto());
        existeProducto.setStock(producto.getStock());
        existeProducto.setCategoriaId(producto.getCategoriaId());
        ProductoEntity updateProductoEntity=productosRepository.save(existeProducto);
        //return ProductoMapper.MapToProductoDomain(updateProductoEntity);
        return AutoProductoMapper.MAPPER.MapToProductoDomain(updateProductoEntity);
    }

    @Override
    public void deleteProducto(Long ProductoId) {
        productosRepository.deleteById(ProductoId);
    }

}
