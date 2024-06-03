package com.project.gestionPedidos.persistance.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name="producto")
@Data
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer ProductoId;
    private String NombreProducto;
    private Double PrecioProducto;
    private String DescripcionProducto;
    private Integer Stock;
    private Integer CategoriaId;

}
