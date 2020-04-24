package academy.everyonecodes.DTO;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

public class PersonDTO {
    private Long id;
    @NotEmpty
    private String name;
    private List<String> friends;

    public PersonDTO(@NotEmpty String name) {
        this.name = name;
        this.friends = friends;
    }

    public PersonDTO(@NotEmpty String name, List<String> friends) {
        this.name = name;
        this.friends = friends;
    }

    public PersonDTO(Long id, @NotEmpty String name, List<String> friends) {
        this.id = id;
        this.name = name;
        this.friends = friends;
    }

    public PersonDTO() {
    }

    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(id, personDTO.id) &&
                Objects.equals(name, personDTO.name) &&
                Objects.equals(friends, personDTO.friends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, friends);
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", friends=" + friends +
                '}';
    }
}
