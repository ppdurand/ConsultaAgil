package edu.example.ConsultaAgil.application.service;

import edu.example.ConsultaAgil.application.dto.ConsultDTO.*;
import edu.example.ConsultaAgil.application.mapper.ConsultMapper;
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
    private final ConsultMapper mapper;

    public ConsultService(ConsultRepository consultRepository, PatientRepository patientRepository,
                          ConsultMapper mapper) {
        this.repository = consultRepository;
        this.patientRepository = patientRepository;
        this.mapper = mapper;
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
        Consult entity = mapper.toModel(request, consultOptional.get());
        return repository.save(entity);
    }

    public void deleteConsult(Long id) {
        repository.deleteById(id);
    }
}
