package DAO;

import DTO.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * Data Access Object (DAO) class for managing Account entities.
 * This class provides methods for user authentication and retrieving account data from the database.
 * It follows the singleton pattern to ensure a single instance.
 * 
 * @author https://github.com/tychoww
 */
public class AccountDAO {
    private static AccountDAO instance;

    /**
     * Gets the singleton instance of AccountDAO.
     *
     * @return The singleton instance of AccountDAO.
     */
    public static AccountDAO getInstance() {
        return instance == null ? (instance = new AccountDAO()) : instance;
    }

    /**
     * Private constructor to enforce singleton pattern.
     */
    private AccountDAO() { }

    /**
     * Authenticates a user by checking the provided email and password against the database.
     *
     * @param email    The email of the user.
     * @param passWord The password of the user.
     * @return True if the login is successful, false otherwise.
     * @throws RuntimeException if an error occurs while checking login.
     */
    public boolean login(String email, String passWord) {
        String query = "SELECT * FROM [Account] WHERE Email = ? AND Password = ?";

        try (Connection connection = DbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, email);
            statement.setString(2, passWord);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while checking login.", e);
        }
    }

    /**
     * Retrieves an Account object by the provided email from the database.
     *
     * @param email The email of the account.
     * @return An Account object representing the user account.
     * @throws RuntimeException if an error occurs while getting the account by email.
     */
    public Account getAccountByEmail(String email) {
        String query = "SELECT * FROM [Account] WHERE Email = ?";
        
        try (Connection connection = DbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, email);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Account(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting account by email.", e);
        }

        return null;
    }
}
