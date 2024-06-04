package com.project.gestionPedidos.persistance.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="subcategoria")
@Data
public class SubCategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer SubCategoriaId;
    String NombreSubCategoria;
}
