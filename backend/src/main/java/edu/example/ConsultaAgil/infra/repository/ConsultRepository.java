package edu.example.ConsultaAgil.infra.repository;

import edu.example.ConsultaAgil.domain.model.Consult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultRepository extends JpaRepository<Consult, Long> {
}
