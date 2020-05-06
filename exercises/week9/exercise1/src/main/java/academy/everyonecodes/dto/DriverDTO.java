package academy.everyonecodes.dto;

import java.util.Objects;
import java.util.Set;

public class DriverDTO {
    private String username;
    private String password;
    private String typeOfCar;
    private Set<String> authorities;
    private boolean isAvailable;

    public DriverDTO(String username, String typeOfCar, Set<String> authorities, boolean isAvailable) {
        this.username = username;
        this.typeOfCar = typeOfCar;
        this.authorities = authorities;
        this.isAvailable = isAvailable;
    }

    public DriverDTO() {
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    String getPassword() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverDTO driverDTO = (DriverDTO) o;
        return Objects.equals(username, driverDTO.username) &&
                Objects.equals(password, driverDTO.password) &&
                Objects.equals(authorities, driverDTO.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, authorities);
    }
}
