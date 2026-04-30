package at.spengergasse.spring_thymeleaf.services;

import at.spengergasse.spring_thymeleaf.requests.PatientRequest;
import at.spengergasse.spring_thymeleaf.entities.Patient;
import at.spengergasse.spring_thymeleaf.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void addPatient(PatientRequest request) {
        Character genderChar = switch (request.gender) {
            case "male"   -> 'M';
            case "female" -> 'F';
            default       -> 'O';
        };
        LocalDate birth = LocalDate.parse(request.birthDate);
        long ssn = Long.parseLong(request.ssn);

        Patient patient = new Patient(request.fName, request.sName, birth, genderChar, ssn);
        patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient findById(int id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found: " + id));
    }
}