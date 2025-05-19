package edu.example.ConsultaAgil.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pacientes")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @OneToMany
    private List<Consult> consults;

    public Patient() {
    }

    public Patient(int id, String nome, List<Consult> consults) {
        this.id = id;
        this.nome = nome;
        this.consults = consults;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Consult> getConsults() {
        return consults;
    }

    public void setConsults(List<Consult> consults) {
        this.consults = consults;
    }
}
