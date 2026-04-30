package at.spengergasse.spring_thymeleaf.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="d_device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="d_type")
    private String type;
    @Column(name="d_room")
    private String room;
    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Reservation> reservations;
    @JsonProperty("room")
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Device() {
    }

    public Device(String room, String type) {
        this.room = room;
        this.type = type;
    }
    @JsonIgnore
    public List<Reservation> getReservations() {
        return reservations;
    }

    public int getId() {
        return id;
    }
}
