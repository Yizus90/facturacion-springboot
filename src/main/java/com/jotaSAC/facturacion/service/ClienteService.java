package com.jotaSAC.facturacion.service;

import com.jotaSAC.facturacion.model.Cliente;
import com.jotaSAC.facturacion.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listarTodos() {
        return repo.findAll();
    }

    public Cliente guardar(Cliente cliente) {
        return repo.save(cliente);
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
