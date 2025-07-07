package edu.example.ConsultaAgil.api.controller;

import edu.example.ConsultaAgil.application.dto.DoctorDTO.CreateDoctor;
import edu.example.ConsultaAgil.application.dto.DoctorDTO.UpdateDoctor;
import edu.example.ConsultaAgil.application.service.DoctorService;
import edu.example.ConsultaAgil.domain.model.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctor);
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> listDoctors() {
        List<Doctor> doctors = doctorService.listDoctors();
        return ResponseEntity.ok(doctors);
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody CreateDoctor request) {
        Doctor newDoctor = doctorService.createDoctor(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDoctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable long id, @RequestBody UpdateDoctor request) {
        Doctor updatedDoctor = doctorService.updateDoctor(request, id);
        if (updatedDoctor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        Doctor existingDoctor = doctorService.getDoctorById(id);
        if (existingDoctor == null) {
            return ResponseEntity.notFound().build();
        }
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}