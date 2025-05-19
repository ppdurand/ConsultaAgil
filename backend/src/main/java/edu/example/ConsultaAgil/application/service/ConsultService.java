package edu.example.ConsultaAgil.application.service;

import edu.example.ConsultaAgil.application.dto.ConsultDTO.*;
import edu.example.ConsultaAgil.domain.model.Consult;
import edu.example.ConsultaAgil.domain.model.Patient;
import edu.example.ConsultaAgil.infra.repository.ConsultRepository;
import edu.example.ConsultaAgil.infra.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultService {
    private final ConsultRepository repository;
    private final PatientRepository patientRepository;

    public ConsultService(ConsultRepository consultRepository, PatientRepository patientRepository) {
        this.repository = consultRepository;
        this.patientRepository = patientRepository;
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
        System.out.println(request);
        Optional<Patient> patient = patientRepository.findById(request.patientId());
        System.out.println(patient);
        if (patient.isEmpty()) {
            return null;
        }
        Consult consult = new Consult(request.date(), patient.get(), request.doctor());

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
