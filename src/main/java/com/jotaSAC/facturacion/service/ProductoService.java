package com.jotaSAC.facturacion.service;

import com.jotaSAC.facturacion.model.Producto;
import com.jotaSAC.facturacion.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listarTodos() {
        return repo.findAll();
    }

    public void guardar(Producto producto) {
        repo.save(producto);
    }

    public Optional<Producto> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}