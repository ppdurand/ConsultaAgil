package edu.example.ConsultaAgil.application.mapper;

import edu.example.ConsultaAgil.application.dto.ConsultDTO;
import edu.example.ConsultaAgil.application.dto.ConsultDTO.*;
import edu.example.ConsultaAgil.domain.model.Consult;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Component;

@Component
public class ConsultMapper {
    public ConsultMapper(){}

    public Consult toModel(UpdateConsult dto, Consult model){
        model.setData(dto.date());
        model.setDoctor(dto.doctor());

        return model;
    }

    public UpdateConsult toDTO(Consult model){
        return new UpdateConsult(model.getDoctor(), model.getData());
    }
}
