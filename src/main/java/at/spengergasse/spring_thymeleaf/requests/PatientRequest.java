package at.spengergasse.spring_thymeleaf.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PatientRequest {
    public String fName;
    public String sName;
    public String birthDate;
    public String gender;
    public String ssn;
}
