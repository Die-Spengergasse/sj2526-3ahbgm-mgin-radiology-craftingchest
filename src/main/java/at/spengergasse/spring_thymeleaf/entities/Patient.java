package at.spengergasse.spring_thymeleaf.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="p_patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name="p_vname")
    private String fname;
    @Column(name="p_sname")
    private String sname;
    @Column(name="p_birth")
    private LocalDate birth;
    @Column(name="p_gender")
    private Character gender;
    @Column(name="p_ssn")
    private long ssn;
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @JsonIgnore
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Reservation> reservations;
        @JsonProperty("fname")
    public String getfName() {
        return fname;
    }
    public void setfName(String vname) {
        this.fname = vname;
    }
    @JsonProperty("birth")
    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
    @JsonProperty("sname")
    public String getSname() {
        return sname;
    }
    @JsonProperty("ssn")
    public long getSsn() {
        return ssn;
    }

    public Character getGender() {
        return gender;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }
    @JsonProperty("gender")
    public void setGender(Character gender) {
        this.gender = gender;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Patient() {
    }

    public Patient(String fname, String sname, LocalDate birth, Character gender, long ssn) {
        this.fname = fname;
        this.sname = sname;
        this.birth = birth;
        this.gender = gender;
        this.ssn = ssn;
    }
}
