package model.util;

import model.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserValidatorTest {
    static UserValidator userValidator;

//    todo make tests methods more compact

    @BeforeClass
    public static void initial() {
        userValidator = UserValidator.getInstance();
    }

    @Before
    public void init() {
    }

    @Test
    public void isValidLoginAccepted() {
        String[] logins = {"mychay", "derfulim"};
        for (String login : logins) {
            System.out.println(login);
            Assert.assertTrue(login.matches(userValidator.getRegexFromProperties("login")));
        }
    }

    @Test
    public void isValidEmailAccepted() {
        Assert.assertTrue("y.barashenko@gmail.com".matches(userValidator.getRegexFromProperties("email")));
    }

    @Test
    public void isValidPasswordAccepted() {
        Assert.assertTrue("123456".matches(userValidator.getRegexFromProperties("password")));
    }

    @Test
    public void isValidUkrainianNameAccepted() {
        Assert.assertTrue("Ярослав".matches(userValidator.getRegexFromProperties("name.ua")));
    }

    @Test
    public void isValidEnglishNameAccepted() {
        Assert.assertTrue("Yaroslav".matches(userValidator.getRegexFromProperties("name.en")));
    }

    @Test
    public void isValidEnglishSurnameAccepted() {

        String[] surnames = {"Barashenko", "Snow", "M'Quilan"};
        for (String surname : surnames) {
            System.out.println(surname);
            Assert.assertTrue(surname.matches(userValidator.getRegexFromProperties("surname.en")));
        }
    }

    @Test
    public void isInvalidEnglishSurnameRejected() {

        String[] surnames = {"Барашенко"};
        for (String surname : surnames) {
            System.out.println(surname);
            Assert.assertFalse(surname.matches(userValidator.getRegexFromProperties("surname.en")));
        }
    }

        @Test
        public void isValidUkrainianSurnameAccepted() {

            String[] surnames = {"Барашенко"};
            for (String surname : surnames) {
                System.out.println(surname);
                Assert.assertTrue(surname.matches(userValidator.getRegexFromProperties("surname.ua")));
            }
        }

    @Test
    public void isInvalidUkrainianSurnameRejected() {

        String[] surnames = {"Barashenko", "Я"};
        for (String surname : surnames) {
            System.out.println(surname);
            Assert.assertFalse(surname.matches(userValidator.getRegexFromProperties("surname.ua")));
        }
    }


    }

