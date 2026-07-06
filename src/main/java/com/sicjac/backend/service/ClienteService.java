package com.sicjac.backend.service;

import com.sicjac.backend.model.Cliente;
import com.sicjac.backend.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository usuarioRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.usuarioRepository = clienteRepository;
    }

    public List<Cliente> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Cliente guardar(Cliente cliente) {
        return usuarioRepository.save(cliente);
    }

    public Cliente actualizar(Long id, Cliente cliente) {
        cliente.setId(id);
        return usuarioRepository.save(cliente);
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
