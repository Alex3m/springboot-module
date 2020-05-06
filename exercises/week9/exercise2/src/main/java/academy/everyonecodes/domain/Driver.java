package academy.everyonecodes.domain;

import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Driver {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String typeOfCar;
    @OneToMany
    private List<Ride> rides = new ArrayList<>();

    public Driver() {
    }

    public Driver(Long id, String username, String password, String typeOfCar, List<Ride> rides) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.typeOfCar = typeOfCar;
        this.rides = rides;
    }

    public Driver(String username, String password, String typeOfCar) {
        this.username = username;
        this.password = password;
        this.typeOfCar = typeOfCar;
    }

    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
}
