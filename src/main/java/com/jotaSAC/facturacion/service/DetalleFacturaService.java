package com.jotaSAC.facturacion.service;

import com.jotaSAC.facturacion.model.DetalleFactura;
import com.jotaSAC.facturacion.repository.DetalleFacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalleFacturaService {

    private final DetalleFacturaRepository repo;

    public DetalleFactura guardar(DetalleFactura detalle) {
        return repo.save(detalle);
    }
}