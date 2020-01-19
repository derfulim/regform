package model.util;

import model.dto.InvalidData;
import model.entity.User;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UserValidator {

    private static volatile UserValidator userValidator;
    private final String regex_container = "D:\\Own\\regform\\src\\main\\resources\\regex_container.properties";
    private InvalidData invalidData = new InvalidData();

    private UserValidator() {
    }

    public static UserValidator getInstance() {
        UserValidator localInstance = userValidator;
        if (localInstance == null) {
            synchronized (UserValidator.class) {
//                    localInstance = userValidator;
                if (localInstance == null) {
                    userValidator = new UserValidator();
//                        LOGGER.debug("Create first DefaultUserValidator instance");
                }
            }
        }
//            LOGGER.debug("Return DefaultUserValidator instance");
        return userValidator;
    }


    //todo make validator singleton
//todo add logger
    //todo which path is better to use in java apps

    public boolean isValid(User user) {
        boolean isValidFlag = true;

        String login = user.getLogin();
        String email = user.getEmail();
        String password = user.getPassword();

        if (!login.matches(getRegexFromProperties("login"))) {
            System.out.println("User login is not valid");
            invalidData.setLogin(login);
            isValidFlag = false;
        }

        //TODO use responsible constructive pattern
        else invalidData.setLogin(null);

        if (!email.matches(getRegexFromProperties("email"))) {
            System.out.println("User email is not valid");
            invalidData.setEmail(email);
            isValidFlag = false;
        } else invalidData.setEmail(null);
        if (!user.getNameUa().matches(getRegexFromProperties("name.ua"))) {
            invalidData.setNameUa(user.getNameUa());
            System.out.println("User nameUa is not valid");
            isValidFlag = false;
        } else invalidData.setNameUa(null);
        if (!user.getSurnameUa().matches(getRegexFromProperties("surname.ua"))) {
            System.out.println("User surnameUa is not valid");
            invalidData.setSurnameUa(user.getSurnameUa());
            isValidFlag = false;
        } else invalidData.setSurnameUa(null);
        if (!user.getNameEng().matches(getRegexFromProperties("name.en"))) {
            System.out.println("User nameEng is not valid");
            invalidData.setNameEng(user.getNameEng());
            isValidFlag = false;
        } else invalidData.setNameEng(null);

        if (!user.getSurnameEng().matches(getRegexFromProperties("surname.en"))) {
            System.out.println("User surnameEng is not valid");
            invalidData.setSurnameEng(user.getSurnameEng());
            isValidFlag = false;
        } else invalidData.setSurnameEng(null);

        if (!password.matches(getRegexFromProperties("password"))) {
            System.out.println("User password is not valid");
            invalidData.setPassword(password);
            isValidFlag = false;
        } else invalidData.setPassword(null);

        return isValidFlag;
    }

    public String getRegexFromProperties(String regname) {
        Properties properties = new Properties();
        String regex = null;

        try (FileReader reader = new FileReader(regex_container)) {
            properties.load(reader);
            regex = properties.getProperty(regname);
        } catch (IOException e) {
        }

        return regex;
    }

    public InvalidData getInvalidData() {
        return invalidData;
    }

    public void setInvalidData(InvalidData invalidData) {
        this.invalidData = invalidData;
    }


}
