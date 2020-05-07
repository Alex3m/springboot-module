package academy.everyonecodes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
public class SteamUser {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    @ManyToMany(fetch = EAGER)
    private Set<SteamGame> steamGames = new HashSet<>();

    public SteamUser(String username, Set<SteamGame> steamGames) {
        this.username = username;
        this.steamGames = steamGames;
    }

    public SteamUser(String username) {
        this.username = username;
    }

    public SteamUser() {
    }


    public Set<SteamGame> getSteamGames() {
        return steamGames;
    }

    public void setSteamGames(Set<SteamGame> steamGames) {
        this.steamGames = steamGames;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SteamUser steamUser = (SteamUser) o;
        return Objects.equals(id, steamUser.id) &&
                Objects.equals(username, steamUser.username) &&
                Objects.equals(steamGames, steamUser.steamGames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, steamGames);
    }
}
