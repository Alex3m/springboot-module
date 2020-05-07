package academy.everyonecodes.domain;

import java.util.Arrays;
import java.util.Objects;

public class SteamUser {
    private String id;

    private String username;
    private String password;
    private String[] authorities;

    public SteamUser(String username, String password, String[] authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public SteamUser() {
    }

    public String getId() {
        return id;
    }

    void setId(String id) {
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

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SteamUser that = (SteamUser) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Arrays.equals(authorities, that.authorities);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, username, password);
        result = 31 * result + Arrays.hashCode(authorities);
        return result;
    }
}
