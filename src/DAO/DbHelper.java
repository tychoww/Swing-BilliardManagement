package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Helper class for managing database connections.
 * This class follows the singleton pattern to ensure a single instance.
 * It provides a method to obtain a connection to the database.
 * 
 * Note: It's recommended to use connection pooling for production applications.
 *       This helper is for demonstration purposes and may not be suitable for high-performance scenarios.
 * 
 * @author https://github.com/tychoww
 */
public class DbHelper {
    private static DbHelper instance;

    /**
     * Gets the singleton instance of DbHelper.
     *
     * @return The singleton instance of DbHelper.
     */
    public static DbHelper getInstance() {
        return instance == null ? (instance = new DbHelper()) : instance;
    }

    /**
     * Private constructor to enforce singleton pattern.
     */
    private DbHelper() { }
    
    private static final String JDBC_URL = "jdbc:sqlserver://DESKTOP-2FPKFOT:1433;databaseName=BilliardManagement;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "chauden11";
   
    /**
     * Obtains a connection to the database.
     *
     * @return A Connection object representing the database connection.
     * @throws RuntimeException if unable to connect to the database.
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to the database.", e);
        }
    }
}