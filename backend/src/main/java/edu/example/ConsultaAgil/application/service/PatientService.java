package edu.example.ConsultaAgil.application.service;

import edu.example.ConsultaAgil.application.dto.PatientDTO.*;
import edu.example.ConsultaAgil.application.mapper.PatientMapper;
import edu.example.ConsultaAgil.domain.model.Patient;
import edu.example.ConsultaAgil.infra.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository repository;
    private final PatientMapper mapper;

    public PatientService(PatientRepository repository, PatientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Patient getPatientById(long id) {
        Optional<Patient> consult = repository.findById(id);
        return consult.orElse(null);
    }

    public List<Patient> listPatients() {
        return repository.findAll();
    }

    public Patient createPatient(CreatePatient request){
        Patient patient = new Patient(request.name(), request.telephone());
        return repository.save(patient);
    }

    public Patient updatePatient(UpdatePatient request, long id) {
        Optional<Patient> consult = repository.findById(id);
        if(consult.isEmpty()) {
            return null;
        }

        Patient entity = mapper.toModel(request, consult.get());
        return repository.save(entity);
    }

    public void deletePatient(long id) {
        repository.deleteById(id);
    }
}
