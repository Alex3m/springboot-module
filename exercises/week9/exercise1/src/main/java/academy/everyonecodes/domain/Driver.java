package academy.everyonecodes.domain;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Objects;
import java.util.Set;

public class Driver {

    private String id;

    @Indexed(unique = true)
    private String username;
    private String password;
    private String typeOfCar;
    private Set<String> authorities;
    private boolean isAvailable;

    public Driver() {
    }

    public Driver(String username, String password, String typeOfCar, Set<String> authorities) {
        this.username = username;
        this.password = password;
        this.typeOfCar = typeOfCar;
        this.authorities = authorities;
    }

    public Driver(String username, String password, Set<String> authorities, boolean isAvailable) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.isAvailable = isAvailable;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return isAvailable == driver.isAvailable &&
                Objects.equals(id, driver.id) &&
                Objects.equals(username, driver.username) &&
                Objects.equals(password, driver.password) &&
                Objects.equals(authorities, driver.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, authorities, isAvailable);
    }
}
