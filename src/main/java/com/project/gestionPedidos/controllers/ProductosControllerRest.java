package com.project.gestionPedidos.controllers;

import com.project.gestionPedidos.domain.Producto;
import com.project.gestionPedidos.services.ProductosServiceBDImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @GetMapping("{id}")
    public ResponseEntity<?> getProductosById(@PathVariable("id") Long productoId){
        Producto producto=productosServiceBD.getProductoById(productoId);
        return new ResponseEntity<>(producto, HttpStatus.OK);
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
    @PutMapping("{id}")
    public ResponseEntity<?> updateProducto(@PathVariable("id") Long productoId,@RequestBody Producto producto){
        producto.setProductoId(productoId);
        Producto updateProducto=productosServiceBD.updateProducto(producto);
        return new ResponseEntity<>(updateProducto, HttpStatus.OK);

    }
    @DeleteMapping  ("{id}")
    public ResponseEntity<?> updateProducto(@PathVariable("id") Long productoId){
        productosServiceBD.deleteProducto(productoId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);

    }
}
