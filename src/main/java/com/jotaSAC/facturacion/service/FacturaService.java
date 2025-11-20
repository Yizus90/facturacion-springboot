package com.jotaSAC.facturacion.service;

import com.jotaSAC.facturacion.model.Factura;
import com.jotaSAC.facturacion.model.DetalleFactura;
import com.jotaSAC.facturacion.model.Producto;
import com.jotaSAC.facturacion.repository.FacturaRepository;
import com.jotaSAC.facturacion.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FacturaService {

    private final FacturaRepository facturaRepository;
    private final ProductoRepository productoRepository;

    @Transactional
    public Factura guardarFactura(Factura factura) {

        // Validar stock y actualizar
        for (DetalleFactura det : factura.getDetalles()) {

            Producto prod = productoRepository.findById(det.getProducto().getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            if (prod.getStock() < det.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para el producto: " + prod.getNombre());
            }

            // Disminuye stock
            prod.setStock(prod.getStock() - det.getCantidad());
            productoRepository.save(prod);

            // Setea el precio unitario y total en el detalle
            det.setPrecioUnitario(prod.getPrecio());
            det.calcularTotal();

            // Une el detalle con la factura
            det.setFactura(factura);
        }

        // Calcular subtotal, igv y total
        factura.calcularTotales();

        return facturaRepository.save(factura);
    }

    public Factura buscarPorId(Long id) {
        return facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

    public java.util.List<Factura> listarTodas() {
        return facturaRepository.findAll();
    }
}