package at.spengergasse.spring_thymeleaf.requests;

import java.time.LocalDateTime;

public class ReservationRequest {
    public int patientId;
    public int deviceId;
    public String date;
    public String bodyregion;
    public String comments;
}
