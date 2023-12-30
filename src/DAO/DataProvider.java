package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataProvider {
    private static final String JDBC_URL = "jdbc:sqlserver://DESKTOP-2FPKFOT:1433;databaseName=BilliardManagement;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "chauden11";
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to the database.");
        }
    }
    
    public ResultSet executeQuery(String query) {
        ResultSet data = null;

        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                data = statement.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to the database.");
        }

        return data;
    }

    public int executeNonQuery(String query) {
        int data = 0;

        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                data = statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to the database.");
        }

        return data;
    }

    public Object executeScalar(String query, Object[] parameters) {
        Object data = null;

        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                if (parameters != null) {
                    for (int i = 0; i < parameters.length; i++) {
                        statement.setObject(i + 1, parameters[i]);
                    }
                }

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        data = resultSet.getObject(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to the database.");
        }

        return data;
    }
}
