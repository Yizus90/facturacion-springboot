package com.jotaSAC.facturacion.repository;

import com.jotaSAC.facturacion.model.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Long> {
}