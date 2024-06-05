package com.project.gestionPedidos.persistance.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ProductoId")
    private Long ProductoId;
    @Column(name = "NombreProducto")
    private String nombreProducto;
    @Column(name = "PrecioProducto")
    private Double PrecioProducto;
    @Column(name = "DescripcionProducto")
    private String DescripcionProducto;
    @Column(name = "Stock")
    private Integer Stock;
    @Column(name = "CategoriaId")
    private Integer CategoriaId;

}
