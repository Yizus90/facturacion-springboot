package com.jotaSAC.facturacion.controller;

import com.jotaSAC.facturacion.model.Cliente;
import com.jotaSAC.facturacion.model.DetalleFactura;
import com.jotaSAC.facturacion.model.Factura;
import com.jotaSAC.facturacion.model.Producto;
import com.jotaSAC.facturacion.service.ClienteService;
import com.jotaSAC.facturacion.service.FacturaService;
import com.jotaSAC.facturacion.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/facturas")
@RequiredArgsConstructor
public class FacturaController {

    private final FacturaService facturaService;
    private final ClienteService clienteService;
    private final ProductoService productoService;

    // LISTADO
    @GetMapping
    public String listarFacturas(Model model) {
        model.addAttribute("facturas", facturaService.listarTodas());
        return "facturas/lista";
    }

    // FORMULARIO CREAR FACTURA
    @GetMapping("/nueva")
    public String nuevaFactura(Model model) {

        Factura factura = new Factura();
        factura.setDetalles(new ArrayList<>());

        model.addAttribute("factura", factura);
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("productos", productoService.listarTodos());

        return "facturas/form";
    }

    // AGREGAR DETALLE DINÁMICO (cuando se envíe el formulario)
    @PostMapping("/agregarDetalle")
    public String agregarDetalle(
            @ModelAttribute Factura factura,
            @RequestParam Long productoId,
            @RequestParam Integer cantidad,
            Model model) {

        Producto producto = productoService.buscarPorId(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        DetalleFactura detalle = new DetalleFactura();
        detalle.setProducto(producto);
        detalle.setCantidad(cantidad);
        detalle.setPrecioUnitario(producto.getPrecio());
        detalle.calcularTotal();

        factura.getDetalles().add(detalle);

        model.addAttribute("factura", factura);
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("productos", productoService.listarTodos());

        return "facturas/form";
    }

    // GUARDAR FACTURA COMPLETA
    @PostMapping("/guardar")
    public String guardarFactura(@ModelAttribute Factura factura) {

        if (factura.getDetalles().isEmpty()) {
            throw new RuntimeException("La factura debe tener al menos un producto");
        }

        facturaService.guardarFactura(factura);

        return "redirect:/facturas";
    }

    // VER FACTURA ESPECÍFICA
    @GetMapping("/{id}")
    public String verFactura(@PathVariable Long id, Model model) {
        Factura factura = facturaService.buscarPorId(id);
        model.addAttribute("factura", factura);
        return "facturas/detalle";
    }

}