package edu.example.ConsultaAgil.application.mapper;

import edu.example.ConsultaAgil.application.dto.PatientDTO.*;
import edu.example.ConsultaAgil.domain.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
    public PatientMapper(){}

    public Patient toModel(UpdatePatient dto, Patient model){
        model.setNome(dto.name());
        model.setTelephone(dto.telephone());
        model.setConsults(dto.consults());

        return model;
    }

    public UpdatePatient toDTO(Patient patient){
        return new UpdatePatient(patient.getNome(), patient.getTelephone(), patient.getConsults());
    }

}
