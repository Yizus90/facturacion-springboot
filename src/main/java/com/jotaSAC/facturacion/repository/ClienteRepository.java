package com.jotaSAC.facturacion.repository;

import com.jotaSAC.facturacion.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}