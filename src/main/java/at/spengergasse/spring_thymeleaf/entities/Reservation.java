package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.*;

@Entity
@Table (name="r_reservation")
public class Reservation {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int id;
        @ManyToOne
        @JoinColumn(name = "r_p_id")
        private Patient patient;
        @ManyToOne
        @JoinColumn(name = "r_d_id")
        private Device device;
        private String date;
        @Column(name="r_bodyregion")
        private String bodyregion;
        @Column(name="r_comments")
        private String comments;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getBodyregion() {
        return bodyregion;
    }

    public void setBodyregion(String bodyregion) {
        this.bodyregion = bodyregion;
    }

    public Patient getPatient() {
            return patient;
        }

        public void setPatient(Patient patient) {
            this.patient = patient;
        }

        public Device getDevice() {
            return device;
        }

        public void setDevice(Device device) {
            this.device = device;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

    public Reservation() {
    }

    public Reservation(String comments, String bodyregion, String date, Device device, Patient patient) {
        this.comments = comments;
        this.bodyregion = bodyregion;
        this.date = date;
        this.device = device;
        this.patient = patient;
    }
}
