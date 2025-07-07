package edu.example.ConsultaAgil.application.dto;

import edu.example.ConsultaAgil.domain.model.EspecialidadeMedica;

public class DoctorDTO {
    public record CreateDoctor(String name, EspecialidadeMedica especialidadeMedica) {}
    public record UpdateDoctor(String name, EspecialidadeMedica especialidadeMedica) {}
}