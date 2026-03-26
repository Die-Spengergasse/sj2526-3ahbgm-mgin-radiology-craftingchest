package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="p_patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name="p_fname")
    private String fname;
    @Column(name="p_sname")
    private String sname;
    @Column(name="p_birth")
    private LocalDate birth;
    @Column(name="p_gender")
    private Character gender;
    @Column(name="p_ssn")
    private long ssn;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Reservation> reservations;
    public String getfName() {
        return fname;
    }

    public void setfName(String vname) {
        this.fname = vname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
    public String getSname() {
        return sname;
    }

    public long getSsn() {
        return ssn;
    }

    public Character getGender() {
        return gender;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

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
