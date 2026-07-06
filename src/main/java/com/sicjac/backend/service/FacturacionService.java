package com.sicjac.backend.service;

import com.sicjac.backend.model.Facturacion;
import com.sicjac.backend.repository.FacturacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturacionService {

    private final FacturacionRepository facturacionRepository;

    public FacturacionService(FacturacionRepository facturacionRepository) {
        this.facturacionRepository = facturacionRepository;
    }

    public List<Facturacion> listarTodos() {
        return facturacionRepository.findAll();
    }

    public Optional<Facturacion> buscarPorId(Long id) {
        return facturacionRepository.findById(id);
    }

    public Facturacion guardar(Facturacion facturacion) {
        return facturacionRepository.save(facturacion);
    }

    public Facturacion actualizar(Long id, Facturacion facturacion) {
        facturacion.setId(id);
        return facturacionRepository.save(facturacion);
    }

    public void eliminar(Long id) {
        facturacionRepository.deleteById(id);
    }
}
