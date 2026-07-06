package com.sicjac.backend.controller;

import com.sicjac.backend.model.Informe;
import com.sicjac.backend.service.InformeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/informes")
@CrossOrigin(origins = "*")
public class InformeController {

    private final InformeService informeService;

    public InformeController(InformeService informeService) {
        this.informeService = informeService;
    }

    @GetMapping
    public List<Informe> listarTodos() {
        return informeService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Informe> buscarPorId(@PathVariable Long id) {
        return informeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Informe guardar(@Valid @RequestBody Informe informe) {
        return informeService.guardar(informe);
    }

    @PutMapping("/{id}")
    public Informe actualizar(@PathVariable Long id,
                              @Valid @RequestBody Informe informe) {
        return informeService.actualizar(id, informe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        informeService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}