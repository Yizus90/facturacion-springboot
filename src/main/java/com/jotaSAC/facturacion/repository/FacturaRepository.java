package com.jotaSAC.facturacion.repository;

import com.jotaSAC.facturacion.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}