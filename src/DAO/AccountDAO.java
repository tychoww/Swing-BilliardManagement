package DAO;

import DTO.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class AccountDAO {
    private static AccountDAO instance;

    public static AccountDAO getInstance() {
        return instance == null ? (instance = new AccountDAO()) : instance;
    }

    private AccountDAO() { }

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
            throw new RuntimeException("Error while checking login.");
        }
    }
    
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
            throw new RuntimeException("Error getting account by email.");
        }

        return null;
    }
}
