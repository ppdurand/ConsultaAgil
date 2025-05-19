package edu.example.ConsultaAgil.application.service;

import edu.example.ConsultaAgil.application.dto.ConsultDTO.*;
import edu.example.ConsultaAgil.domain.model.Consult;
import edu.example.ConsultaAgil.infra.repository.ConsultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultService {
    private final ConsultRepository repository;

    public ConsultService(ConsultRepository consultRepository) {
        this.repository = consultRepository;
    }

    public Consult getConsultById(Long id) {
        Optional<Consult> consultOptional = repository.findById(id);
        if (consultOptional.isPresent()) {
            return consultOptional.get();
        }
        return null;
    }

    public List<Consult> listConsults(){
        return repository.findAll();
    }

    public Consult createConsult(CreateConsult request) {
        Consult consult = new Consult(request.date(), request.patient(), request.doctor());

        return repository.save(consult);
    }

    public Consult updateConsult(UpdateConsult request, Long id) {
        Optional<Consult> consultOptional = repository.findById(id);
        if (consultOptional.isEmpty()) {
            return null;
        }
        Consult consult = consultOptional.get();

        consult.update(request.date(), request.doctor());
        return repository.save(consult);
    }

    public void deleteConsult(Long id) {
        repository.deleteById(id);
    }
}
