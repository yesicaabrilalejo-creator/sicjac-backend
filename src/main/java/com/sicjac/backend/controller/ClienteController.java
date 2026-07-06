package com.sicjac.backend.controller;

import com.sicjac.backend.model.Cliente;
import com.sicjac.backend.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService usuarioService;

    public ClienteController(ClienteService clienteService) {
        this.usuarioService = clienteService;
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return usuarioService.guardar(cliente);
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return usuarioService.actualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
