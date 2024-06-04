package com.project.gestionPedidos.controllers;

import com.project.gestionPedidos.domain.Producto;
import com.project.gestionPedidos.services.ProductosServiceBDImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosControllerRest {
    @Autowired
    private ProductosServiceBDImpl productosServiceBD;
    @GetMapping
    public ResponseEntity<?> getProductos(){
        List<Producto> productos=productosServiceBD.getProductos();
        return ResponseEntity.ok(productos);
    }
    @PostMapping
    public ResponseEntity<?> altaProducto(@RequestBody Producto producto){
        productosServiceBD.saveProducto(producto);
        //OBTENIENDO URL DE SERVICIO
        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(producto.getProductoId())
                .toUri();
        return ResponseEntity.created(location).body(producto);
    }
}
