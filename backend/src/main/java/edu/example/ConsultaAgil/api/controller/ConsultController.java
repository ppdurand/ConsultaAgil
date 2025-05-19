package edu.example.ConsultaAgil.api.controller;

import edu.example.ConsultaAgil.application.dto.ConsultDTO.*;
import edu.example.ConsultaAgil.application.service.ConsultService;
import edu.example.ConsultaAgil.domain.model.Consult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("consult")
public class ConsultController {
    private final ConsultService service;

    public ConsultController(ConsultService service) {
        this.service = service;
    }

    public ResponseEntity<Consult> getConsultById(long id) {
        Consult response = service.getConsultById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<List<Consult>> listConsult() {
        List<Consult> response = service.listConsults();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Consult> addConsult(CreateConsult request) {
        Consult response = service.createConsult(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Consult> updateConsult(long id, UpdateConsult request) {
        Consult response = service.updateConsult(request, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Consult> deleteConsult(long id) {
        service.deleteConsult(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
