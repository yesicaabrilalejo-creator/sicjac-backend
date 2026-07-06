package com.sicjac.backend.service;

import com.sicjac.backend.model.Informe;
import com.sicjac.backend.repository.InformeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformeService {

    private final InformeRepository informeRepository;

    public InformeService(InformeRepository informeRepository) {
        this.informeRepository = informeRepository;
    }

    public List<Informe> listarTodos() {
        return informeRepository.findAll();
    }

    public Optional<Informe> buscarPorId(Long id) {
        return informeRepository.findById(id);
    }

    public Informe guardar(Informe informe) {
        return informeRepository.save(informe);
    }

    public Informe actualizar(Long id, Informe informe) {
        informe.setId(id);
        return informeRepository.save(informe);
    }

    public void eliminar(Long id) {
        informeRepository.deleteById(id);
    }
}