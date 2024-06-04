package com.project.gestionPedidos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private Long ProductoId;
    private String NombreProducto;
    private Double PrecioProducto;
    private String DescripcionProducto;
    private Integer Stock;
    private Integer CategoriaId;
}
