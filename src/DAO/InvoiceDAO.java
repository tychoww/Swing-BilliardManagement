package DAO;

import DTO.Invoice;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

/**
 * Data Access Object (DAO) for handling operations related to the 'Invoice' entity.
 * This class provides methods for creating invoices, retrieving all invoices, 
 * getting unpaid invoices by table ID, and obtaining the maximum InvoiceID.
 * It utilizes the singleton pattern to ensure a single instance of the class.
 * 
 * @author https://github.com/tychoww
 */
public class InvoiceDAO {
    private static InvoiceDAO instance;

    /**
     * Gets the singleton instance of InvoiceDAO.
     *
     * @return The singleton instance of InvoiceDAO.
     */
    public static InvoiceDAO getInstance() {
        return instance == null ? (instance = new InvoiceDAO()) : instance;
    }

    /**
     * Private constructor to enforce singleton pattern.
     */
    private InvoiceDAO() { }

    /**
     * Creates a new invoice for the specified table.
     *
     * @param tableID The ID of the table for which the invoice is created.
     * @throws RuntimeException if an error occurs while updating invoices by tableID.
     */
    public void createInvoice(int tableID) {
        String query = "INSERT INTO [Invoice] (TableID) VALUES (?)";

        try (Connection connection = DbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, tableID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating invoices by tableID.", e);
        }
    }
    
    public void updateInvoiceCheckout(int invoiceID) {
        String query = "UPDATE [Invoice] SET DateCheckout = GETDATE() WHERE InvoiceID = ?";

        try (Connection connection = DbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, invoiceID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating invoices by invoiceID.", e);
        }
    }

    /**
     * Retrieves a list of all invoices in the system.
     *
     * @return A list of Invoice objects representing all invoices.
     * @throws RuntimeException if an error occurs while loading the invoice list.
     */
    public List<Invoice> getAllInvoiceList() {
        List<Invoice> invoiceList = new ArrayList<>();

        String query = "SELECT * FROM [Invoice];";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                // Extracting invoice data from the result set
                int invoiceID = resultSet.getInt("InvoiceID");
                int customerID = resultSet.getInt("CustomerID");
                int tableID = resultSet.getInt("TableID");
                LocalDateTime dateCheckin = resultSet.getTimestamp("DateCheckin").toLocalDateTime();
                LocalDateTime dateCheckout = resultSet.getObject("DateCheckout") != null
                        ? resultSet.getTimestamp("DateCheckout").toLocalDateTime()
                        : null;
                int status = resultSet.getInt("Status");
                double totalPrice = resultSet.getDouble("TotalPrice");

                // Creating an Invoice object and adding it to the list
                Invoice invoice = new Invoice(invoiceID, customerID, tableID, dateCheckin, dateCheckout, status, totalPrice);
                invoiceList.add(invoice);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading invoice list.", e);
        }

        return invoiceList;
    }

    /**
     * Retrieves the unpaid invoice for the specified table.
     *
     * @param tableID The ID of the table.
     * @return An Invoice object representing the unpaid invoice for the specified table.
     * @throws RuntimeException if an error occurs while loading the invoice by tableID.
     */
    public Invoice getUnpaidInvoiceByTableID(int tableID) {
        Invoice invoice = null;

        String query = "SELECT * FROM [Invoice] WHERE TableID = ? AND Status=0;";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, tableID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Extracting invoice data from the result set
                    int invoiceID = resultSet.getInt("InvoiceID");
                    int customerID = resultSet.getInt("CustomerID");
                    LocalDateTime dateCheckin = resultSet.getTimestamp("DateCheckin").toLocalDateTime();
                    LocalDateTime dateCheckout = resultSet.getObject("DateCheckout") != null
                            ? resultSet.getTimestamp("DateCheckout").toLocalDateTime()
                            : null;
                    int status = resultSet.getInt("Status");
                    double totalPrice = resultSet.getDouble("TotalPrice");

                    // Creating an Invoice object
                    invoice = new Invoice(invoiceID, customerID, tableID, dateCheckin, dateCheckout, status, totalPrice);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading invoice by tableID.", e);
        }

        return invoice;
    }

    /**
     * Gets the maximum InvoiceID in the system.
     *
     * @return The maximum InvoiceID.
     * @throws RuntimeException if an error occurs while getting the max InvoiceID.
     */
    public int GetMaxInvoiceID() {
        String query = "SELECT MAX(InvoiceID) FROM [Invoice]";

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
    
    public void payForInvoice(int invoiceID, int customerID, double totalPrice) {
        String query;
        if(customerID == 0) {
        query = "UPDATE [Invoice] SET Status = 1, TotalPrice = ?"
                + " WHERE InvoiceID = ?"; 
        } else {      
        query = "UPDATE [Invoice] SET Status = 1, CustomerID=?, TotalPrice = ?"
                + " WHERE InvoiceID = ?"; 
        }

        try (Connection connection = DbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, customerID);
            statement.setDouble(2, totalPrice);
            statement.setInt(3, invoiceID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating invoices by invoiceID.", e);
        }
    }
    
    public boolean isCheckedOut(int invoiceID) {
        String query = "SELECT Status FROM [Invoice] WHERE InvoiceID = ?";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, invoiceID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int status = resultSet.getInt("Status");
                    return status == 1; // Assuming 1 represents checked out status
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error checking invoice status.", e);
        }

        // Return false if no data or an error occurs
        return false;
    }
}