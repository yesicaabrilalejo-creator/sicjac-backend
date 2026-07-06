package com.sicjac.backend.controller;

import com.sicjac.backend.model.Facturacion;
import com.sicjac.backend.service.FacturacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturacion")
@CrossOrigin(origins = "*")
public class FacturacionController {

    private final FacturacionService facturacionService;

    public FacturacionController(FacturacionService facturacionService) {
        this.facturacionService = facturacionService;
    }

    @GetMapping
    public List<Facturacion> listarTodos() {
        return facturacionService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facturacion> buscarPorId(@PathVariable Long id) {
        return facturacionService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Facturacion guardar(@RequestBody Facturacion facturacion) {
        return facturacionService.guardar(facturacion);
    }

    @PutMapping("/{id}")
    public Facturacion actualizar(@PathVariable Long id, @RequestBody Facturacion facturacion) {
        return facturacionService.actualizar(id, facturacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        facturacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
