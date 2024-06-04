package com.project.gestionPedidos.persistance.repositories;

import com.project.gestionPedidos.persistance.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<ProductoEntity, Long> {
}
