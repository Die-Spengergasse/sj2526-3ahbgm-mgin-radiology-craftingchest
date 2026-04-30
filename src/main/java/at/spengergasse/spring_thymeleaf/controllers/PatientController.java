package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Patient;
import at.spengergasse.spring_thymeleaf.requests.PatientRequest;
import at.spengergasse.spring_thymeleaf.services.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // POST /patient/add  — called by addPatient.js
    @PostMapping("/add")
    public ResponseEntity<?> addPatient(@RequestBody PatientRequest request) {
        try {
            patientService.addPatient(request);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/list")
    public ResponseEntity<List<Patient>> listPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }



}