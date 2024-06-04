package com.project.gestionPedidos.persistance.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name="categoria")
@Data
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CategoriaId")
    private Integer CategoriaId;
    @Column(name = "NombreCategoria")
    private String NombreCategoria;
    @Column(name = "SubCategoriaId")
    private Integer SubCategoriaId;
}
