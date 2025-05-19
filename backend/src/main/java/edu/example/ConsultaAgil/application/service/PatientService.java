package edu.example.ConsultaAgil.application.service;

import edu.example.ConsultaAgil.application.dto.PatientDTO.*;
import edu.example.ConsultaAgil.domain.model.Patient;
import edu.example.ConsultaAgil.infra.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

public class PatientService {
    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
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

        Patient patient = consult.get();
        patient.update(request.name(), request.telephone(), request.consults());
        return repository.save(patient);
    }

    public void deletePatient(long id) {
        repository.deleteById(id);
    }
}
