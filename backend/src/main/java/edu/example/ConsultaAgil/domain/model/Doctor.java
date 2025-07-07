package edu.example.ConsultaAgil.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medicos")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private EspecialidadeMedica especialidadeMedica;

    public Doctor() {
    }

    public Doctor(String name, EspecialidadeMedica especialidadeMedica) {
        this.name = name;
        this.especialidadeMedica = especialidadeMedica;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EspecialidadeMedica getEspecialidadeMedica() {
        return especialidadeMedica;
    }

    public void setEspecialidadeMedica(EspecialidadeMedica especialidadeMedica) {
        this.especialidadeMedica = especialidadeMedica;
    }
}
