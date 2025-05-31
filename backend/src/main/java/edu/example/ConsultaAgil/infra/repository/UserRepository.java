package edu.example.ConsultaAgil.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.example.ConsultaAgil.domain.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String>{
    User findByUsername(String username);
    Optional<User> findByEmail(String email);

}