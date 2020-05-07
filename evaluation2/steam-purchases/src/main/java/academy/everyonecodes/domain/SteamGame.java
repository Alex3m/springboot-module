package academy.everyonecodes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class SteamGame {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String gameID;

    private String gameName;
    private double gamePrice;

    public SteamGame(String gameID, String gameName, double gamePrice) {
        this.gameID = gameID;
        this.gameName = gameName;
        this.gamePrice = gamePrice;
    }
    public SteamGame() {
    }

    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(double gamePrice) {
        this.gamePrice = gamePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SteamGame steamGame = (SteamGame) o;
        return Double.compare(steamGame.gamePrice, gamePrice) == 0 &&
                Objects.equals(gameID, steamGame.gameID) &&
                Objects.equals(gameName, steamGame.gameName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameID, gameName, gamePrice);
    }
}
