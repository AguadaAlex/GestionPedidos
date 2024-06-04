package com.project.gestionPedidos.services;

import com.project.gestionPedidos.domain.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> getProductos();
    public void saveProducto(Producto producto);
    public Producto getProductoById(Integer ProductoId);
}
