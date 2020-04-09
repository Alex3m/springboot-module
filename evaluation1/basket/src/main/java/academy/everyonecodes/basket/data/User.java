package academy.everyonecodes.basket.data;

public class User {
    private String email;
    private String accountType;

    public User() {
    }

    public User(String email, String accountType) {
        this.email = email;
        this.accountType = accountType;
    }

    public String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
