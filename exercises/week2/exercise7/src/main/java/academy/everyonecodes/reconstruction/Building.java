package academy.everyonecodes.reconstruction;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
@Service
public class Building {
    private String name;
    private LocalDate build;
    private boolean historic;

    public Building() {
    }

    public Building(String name, LocalDate build, boolean historic) {
        this.name = name;
        this.build = build;
        this.historic = historic;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public LocalDate getBuild() {
        return build;
    }

    void setBuild(LocalDate build) {
        this.build = build;
    }

    public boolean isHistoric() {
        return historic;
    }

    void setHistoric(boolean historic) {
        this.historic = historic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return historic == building.historic &&
                Objects.equals(name, building.name) &&
                Objects.equals(build, building.build);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, build, historic);
    }

}
