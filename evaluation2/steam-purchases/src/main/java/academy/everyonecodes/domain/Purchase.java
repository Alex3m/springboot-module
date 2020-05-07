package academy.everyonecodes.domain;

import java.util.Objects;

public class Purchase {

    private String username;
    private String gameID;
    private String gameName;
    private double gamePrice;

    public Purchase(String username, String gameID, String gameName, double gamePrice) {
        this.username = username;
        this.gameID = gameID;
        this.gameName = gameName;
        this.gamePrice = gamePrice;
    }

    public Purchase() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        Purchase purchase = (Purchase) o;
        return Double.compare(purchase.gamePrice, gamePrice) == 0 &&
                Objects.equals(username, purchase.username) &&
                Objects.equals(gameID, purchase.gameID) &&
                Objects.equals(gameName, purchase.gameName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, gameID, gameName, gamePrice);
    }
}
