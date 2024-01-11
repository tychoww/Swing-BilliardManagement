package DAO;

import DTO.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) class for managing Customer entities.
 * This class provides methods for retrieving customer data from the database.
 * It follows the singleton pattern to ensure a single instance.
 * 
 * @author https://github.com/tychoww
 */
public class CustomerDAO {
    private static CustomerDAO instance;

    /**
     * Gets the singleton instance of CustomerDAO.
     *
     * @return The singleton instance of CustomerDAO.
     */
    public static CustomerDAO getInstance() {
        return instance == null ? (instance = new CustomerDAO()) : instance;
    }

    /**
     * Private constructor to enforce singleton pattern.
     */
    private CustomerDAO() { }

    /**
     * Retrieves a customer by the provided customer ID from the database.
     *
     * @param phoneNumber
     * @return A Customer object representing the customer.
     * @throws RuntimeException if an error occurs while getting the customer by ID.
     */
    public Customer getCustomerByPhone(String phoneNumber) {
        String query = "SELECT * FROM [Customer] WHERE PhoneNumber = ?";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, phoneNumber);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Customer(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting customer by ID.", e);
        }

        return null;
    }

    public void createCustomer(String customerName, String customerAddress, String customerPhone) {
        String query = "INSERT INTO [Customer] (CustomerName, Address, PhoneNumber) VALUES (?, ?, ?)";

        try (Connection connection = DbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, customerName);
            statement.setString(2, customerAddress);
            statement.setString(3, customerPhone);
            
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating invoices by tableID.", e);
        }
    }
    
    public int GetMaxCustomerID() {
        String query = "SELECT MAX(CustomerID) FROM [Customer]";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting max InvoiceID.", e);
        }

        // Return -1 if no data or an error occurs
        return -1;
    }
}
