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
    private String telephone;
    @OneToMany
    private List<Consult> consults;

    public Patient() {
    }

    public Patient(String nome, String telephone) {
        this.nome = nome;
        this.telephone = telephone;
    }

    public Patient update(String name, String telephone, List<Consult> consults){
        this.nome = name;
        this.telephone = telephone;
        this.consults = consults;

        return this;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
