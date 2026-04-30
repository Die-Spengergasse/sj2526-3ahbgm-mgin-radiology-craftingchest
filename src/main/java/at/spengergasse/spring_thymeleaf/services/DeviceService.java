package at.spengergasse.spring_thymeleaf.services;

import at.spengergasse.spring_thymeleaf.entities.Device;
import at.spengergasse.spring_thymeleaf.entities.Reservation;
import at.spengergasse.spring_thymeleaf.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public List<Reservation> getReservationsForDevice(int deviceId) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new IllegalArgumentException("Device not found: " + deviceId));
        return device.getReservations();
    }

    public Device findById(int id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Device not found: " + id));
    }
}