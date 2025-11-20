package com.jotaSAC.facturacion.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private Double subtotal;
    private Double igv;
    private Double total;

    private String estado = "PENDIENTE";

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalles = new ArrayList<>();

    public void calcularTotales() {
        this.subtotal = detalles.stream()
                .mapToDouble(DetalleFactura::getTotal)
                .sum();

        this.igv = subtotal * 0.18;
        this.total = subtotal + igv;
    }
}