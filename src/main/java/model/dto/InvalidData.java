package model.dto;


public class InvalidData {
    private String login;
    private String nameUa;
    private String nameEng;
    private String surnameUa;
    private String surnameEng;
    private String email;
    private String password;

//    todo use builder?

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNameUa() {
        return nameUa;
    }

    public void setNameUa(String nameUa) {
        this.nameUa = nameUa;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public String getSurnameUa() {
        return surnameUa;
    }

    public void setSurnameUa(String surnameUa) {
        this.surnameUa = surnameUa;
    }

    public String getSurnameEng() {
        return surnameEng;
    }

    public void setSurnameEng(String surnameEng) {
        this.surnameEng = surnameEng;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "InvalidData{" +
                "login='" + login + '\'' +
                ", nameUa='" + nameUa + '\'' +
                ", nameEng='" + nameEng + '\'' +
                ", surnameUa='" + surnameUa + '\'' +
                ", surnameEng='" + surnameEng + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
