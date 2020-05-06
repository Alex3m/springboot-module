package academy.everyonecodes.dto;

import academy.everyonecodes.domain.Ride;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class DriverDTO {

    private Long id;
    private String username;
    private String typeOfCar;
    private List<String> rides = new ArrayList<>();

    public DriverDTO(Long id, String username, String typeOfCar, List<String> rides) {
        this.id = id;
        this.username = username;
        this.typeOfCar = typeOfCar;
        this.rides = rides;
    }

    public DriverDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public List<String> getRides() {
        return rides;
    }

    public void setRides(List<String> rides) {
        this.rides = rides;
    }
}
