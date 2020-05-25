package model.dao;

import model.entity.Role;
import model.entity.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String URL = "jdbc:mysql://localhost/regform?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "vFqcrkh0t";

    public boolean addUser(User user) {

        final String SQL = "INSERT INTO user (login,roleid,nameua,nameen,surnameua,surnameen,email,hash) VALUES (?,?,?,?,?,?,?,?)";

        loadDriver();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            System.out.println("Connection is installed");
            preparedStatement.setString(1, user.getLogin());
            switch (user.getRole()) {
                case MODERATOR:
                    preparedStatement.setInt(2, 1);
                    break;
                case SPEAKER:
                    preparedStatement.setInt(2, 2);
                    break;
                case UNKNOWN:
                    preparedStatement.setInt(2, 3);
                    break;
                case VISITOR:
                    preparedStatement.setInt(2, 4);
            }
            preparedStatement.setString(3, user.getNameUa());
            preparedStatement.setString(4, user.getNameEng());
            preparedStatement.setString(5, user.getSurnameUa());
            preparedStatement.setString(6, user.getSurnameEng());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setString(8, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

            preparedStatement.executeUpdate();
            System.out.println("Update executed");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public List<User> getAllUsers() {
        final String SQL = "SELECT login, nameua, nameen, surnameua, surnameen, email, hash, name AS role FROM user JOIN role ON user.roleid = role.idrole GROUP BY iduser";
        List<User> users = new ArrayList<>();

        loadDriver();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setLogin(resultSet.getString("login"));
                    user.setNameUa(resultSet.getString("nameua"));
                    user.setNameEng(resultSet.getString("nameen"));
                    user.setSurnameUa(resultSet.getString("surnameua"));
                    user.setSurnameEng(resultSet.getString("surnameen"));
                    user.setEmail(resultSet.getString("email"));
                    user.setRole(Role.valueOf(resultSet.getString("role")));
                    user.setHash(resultSet.getString("hash"));
                    users.add(user);
                }
                for (User user : users) {
                    System.out.println(user);
                }
            }
        }

        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public static void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
