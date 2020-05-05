package avademy.everyonecodes.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class Artwork {
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @Valid
    private Rating rating;

    public Artwork(String name, Rating rating) {
        this.name = name;
        this.rating = rating;
    }

    public Artwork() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
