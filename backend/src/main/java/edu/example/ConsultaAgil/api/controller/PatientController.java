package edu.example.ConsultaAgil.api.controller;

import edu.example.ConsultaAgil.application.dto.PatientDTO.*;
import edu.example.ConsultaAgil.application.service.PatientService;
import edu.example.ConsultaAgil.domain.model.Patient;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService service;
    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable long id) {
        Patient response = service.getPatientById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Patient>> listPatients() {
        List<Patient> response = service.listPatients();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody CreatePatient request) {
        Patient response = service.createPatient(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable long id, @RequestBody UpdatePatient request) {
        Patient response = service.getPatientById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable long id) {
        Patient response = service.getPatientById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
