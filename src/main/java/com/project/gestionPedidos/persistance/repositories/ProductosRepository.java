package com.project.gestionPedidos.persistance.repositories;

import com.project.gestionPedidos.persistance.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductosRepository extends JpaRepository<ProductoEntity, Long> {
    Optional<ProductoEntity> findByNombreProducto(String NombreProducto);
}
