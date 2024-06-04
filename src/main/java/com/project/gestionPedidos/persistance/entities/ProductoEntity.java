package com.project.gestionPedidos.persistance.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name="producto")
@Data
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ProductoId")
    private Integer ProductoId;
    @Column(name = "NombreProducto")
    private String NombreProducto;
    @Column(name = "PrecioProducto")
    private Double PrecioProducto;
    @Column(name = "DescripcionProducto")
    private String DescripcionProducto;
    @Column(name = "Stock")
    private Integer Stock;
    @Column(name = "CategoriaId")
    private Integer CategoriaId;

}
