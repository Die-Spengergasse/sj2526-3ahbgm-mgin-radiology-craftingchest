package at.spengergasse.spring_thymeleaf.services;

import at.spengergasse.spring_thymeleaf.requests.ReservationRequest;
import at.spengergasse.spring_thymeleaf.entities.Device;
import at.spengergasse.spring_thymeleaf.entities.Patient;
import at.spengergasse.spring_thymeleaf.entities.Reservation;
import at.spengergasse.spring_thymeleaf.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final PatientService patientService;
    private final DeviceService deviceService;

    public ReservationService(ReservationRepository reservationRepository, PatientService patientService, DeviceService deviceService) {
        this.reservationRepository = reservationRepository;
        this.patientService = patientService;
        this.deviceService = deviceService;
    }

    public void addReservation(ReservationRequest request) {
        Patient patient = patientService.findById(request.patientId);
        Device device = deviceService.findById(request.deviceId);

        Reservation reservation = new Reservation(
                request.comments,
                request.bodyregion,
                request.date,
                device,
                patient
        );
        reservationRepository.save(reservation);
    }
}