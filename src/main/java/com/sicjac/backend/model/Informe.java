package com.sicjac.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "informes")
@Getter
@Setter
public class Informe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "La descripción es obligatoria")
    @Column(length = 1000)
    private String descripcion;

    @NotBlank(message = "La fecha es obligatoria")
    private String fecha;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;
}