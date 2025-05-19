package edu.example.ConsultaAgil.domain.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table(name = "consultas")
public class Consult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime data;
    @ManyToOne
    private Patient patient;
    private String doctor;

    public Consult() {}

    public Consult(LocalDateTime data, Patient patient, String doctor) {
        this.data = data;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Consult update(LocalDateTime data, String doctor){
        this.data = data;
        this.doctor = doctor;

        return this;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
