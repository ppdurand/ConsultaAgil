package edu.example.ConsultaAgil.application.mapper;

import edu.example.ConsultaAgil.application.dto.DoctorDTO.UpdateDoctor;
import edu.example.ConsultaAgil.domain.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public Doctor toModel(UpdateDoctor request, Doctor existingDoctor) {
        if (request == null) {
            return null;
        }
        if (request.name() != null) {
            existingDoctor.setName(request.name());
        }
        if (request.especialidadeMedica() != null) {
            existingDoctor.setEspecialidadeMedica(request.especialidadeMedica());
        }
        return existingDoctor;
    }
}