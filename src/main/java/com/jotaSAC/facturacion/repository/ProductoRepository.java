package com.jotaSAC.facturacion.repository;

import com.jotaSAC.facturacion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}