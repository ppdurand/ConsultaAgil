// package edu.example.ConsultaAgil.application.service;
package edu.example.ConsultaAgil.application.service;

import edu.example.ConsultaAgil.application.dto.DoctorDTO.*;
import edu.example.ConsultaAgil.application.mapper.DoctorMapper;
import edu.example.ConsultaAgil.domain.model.Doctor;
import edu.example.ConsultaAgil.infra.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository repository;
    private final DoctorMapper mapper;

    public DoctorService(DoctorRepository repository, DoctorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Doctor getDoctorById(long id) {
        Optional<Doctor> consult = repository.findById(id);
        return consult.orElse(null);
    }

    public List<Doctor> listDoctors() {
        return repository.findAll();
    }

    public Doctor createDoctor(CreateDoctor request){
        Doctor doctor = new Doctor(request.name(), request.especialidadeMedica());
        return repository.save(doctor);
    }

    public Doctor updateDoctor(UpdateDoctor request, long id) {
        Optional<Doctor> consult = repository.findById(id);
        if(consult.isEmpty()) {
            return null;
        }

        Doctor entity = mapper.toModel(request, consult.get());
        return repository.save(entity);
    }

    public void deleteDoctor(Long id) {
        repository.deleteById(id);
    }
}