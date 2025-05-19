package edu.example.ConsultaAgil.application.dto;

import edu.example.ConsultaAgil.domain.model.Consult;

import java.util.List;

public class PatientDTO {
    public record CreatePatient(String name, String telephone){};
    public record UpdatePatient(String name, String telephone, List<Consult> consults){};
}
