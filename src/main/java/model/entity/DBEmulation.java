package model.entity;

public enum DBEmulation {
    YAROSLAV("derfulim", "y.barashenko@gmail.com");

    private final String login;

    private final String email;
    DBEmulation(String login, String email){
        this.login=login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }
}
