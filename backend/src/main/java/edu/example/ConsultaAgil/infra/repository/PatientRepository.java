package edu.example.ConsultaAgil.infra.repository;

import edu.example.ConsultaAgil.domain.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
