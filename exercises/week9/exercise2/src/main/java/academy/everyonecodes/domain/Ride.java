package academy.everyonecodes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ride {
    @Id
    @GeneratedValue
    private Long id;
    private String customerUsername;
    @ManyToOne
    private Driver driver;
    private double distance;
    private double price;

    public Ride(String customerUsername, Driver driver, double distance, double price) {
        this.customerUsername = customerUsername;
        this.distance = distance;
        this.price = price;
    }

    public Ride(String customerUsername, double distance, double price) {
        this.customerUsername = customerUsername;
        this.distance = distance;
        this.price = price;
    }

    public Ride() {
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
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

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", customerUsername='" + customerUsername + '\'' +
                ", distance=" + distance +
                ", price=" + price +
                '}';
    }
}
