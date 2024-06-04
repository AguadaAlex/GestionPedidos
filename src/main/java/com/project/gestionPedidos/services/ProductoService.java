package com.project.gestionPedidos.services;

import com.project.gestionPedidos.domain.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> getProductos();
    public void saveProducto(Producto producto);
    public Producto getProductoById(Long ProductoId);
    public Producto updateProducto(Producto producto);
    public void deleteProducto(Long ProductoId);
}
