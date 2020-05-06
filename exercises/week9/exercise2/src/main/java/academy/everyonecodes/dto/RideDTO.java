package academy.everyonecodes.dto;

import academy.everyonecodes.domain.Driver;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class RideDTO {

    private Long id;
    private String customerUsername;
    private String driverName;
    private double distance;
    private double price;

    public RideDTO(Long id, String customerUsername, String driverName, double distance, double price) {
        this.id = id;
        this.customerUsername = customerUsername;
        this.driverName = driverName;
        this.distance = distance;
        this.price = price;
    }

    public RideDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
