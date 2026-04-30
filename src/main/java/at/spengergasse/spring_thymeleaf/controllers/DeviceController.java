package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Device;
import at.spengergasse.spring_thymeleaf.entities.Reservation;
import at.spengergasse.spring_thymeleaf.services.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }


    @GetMapping("/list")
    public ResponseEntity<List<Device>> listDevices() {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }


    @GetMapping("/reservations/{id}")
    public ResponseEntity<List<Reservation>> getReservations(@PathVariable int id) {
        return ResponseEntity.ok(deviceService.getReservationsForDevice(id));
    }
}