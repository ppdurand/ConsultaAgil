package edu.example.ConsultaAgil.api.controller;

import edu.example.ConsultaAgil.application.dto.ConsultDTO.*;
import edu.example.ConsultaAgil.application.service.ConsultService;
import edu.example.ConsultaAgil.domain.model.Consult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/consults")
public class ConsultController {
    private final ConsultService service;

    public ConsultController(ConsultService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consult> getConsultById(@PathVariable Long id) {
        Consult response = service.getConsultById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Consult>> listConsult() {
        List<Consult> response = service.listConsults();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Consult> addConsult(@RequestBody CreateConsult request) {
        Consult response = service.createConsult(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Consult> updateConsult(@PathVariable Long id, @RequestBody UpdateConsult request) {
        Consult response = service.updateConsult(request, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Consult> deleteConsult(@PathVariable Long id) {
        service.deleteConsult(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
