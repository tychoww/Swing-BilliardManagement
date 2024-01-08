package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private static DbHelper instance;

    public static DbHelper getInstance() {
        return instance == null ? (instance = new DbHelper()) : instance;
    }
    private DbHelper() { }
    
    private static final String JDBC_URL = "jdbc:sqlserver://DESKTOP-2FPKFOT:1433;databaseName=BilliardManagement;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "chauden11";
   
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to the database.");
        }
    }
}
