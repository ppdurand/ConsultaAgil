package edu.example.ConsultaAgil.application.dto;

import java.time.LocalDateTime;

public class ConsultDTO {
    public record CreateConsult(Long patientId, String doctor, LocalDateTime date) {};
    public record UpdateConsult(String doctor, LocalDateTime date) {};
}
