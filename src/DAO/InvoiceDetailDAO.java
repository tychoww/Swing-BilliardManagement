package DAO;

import DTO.InvoiceDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) for handling operations related to the 'Invoice_Detail' entity.
 * This class provides methods for adding invoice details and retrieving details by invoice ID.
 * It utilizes the singleton pattern to ensure a single instance of the class.
 * 
 * @author https://github.com/tychoww
 */
public class InvoiceDetailDAO {
    private static InvoiceDetailDAO instance;

    /**
     * Gets the singleton instance of InvoiceDetailDAO.
     *
     * @return The singleton instance of InvoiceDetailDAO.
     */
    public static InvoiceDetailDAO getInstance() {
        return instance == null ? (instance = new InvoiceDetailDAO()) : instance;
    }

    /**
     * Private constructor to enforce singleton pattern.
     */
    private InvoiceDetailDAO() { }

    /**
     * Adds an invoice detail to the database.
     *
     * @param invoiceID The ID of the invoice.
     * @param dishID    The ID of the dish.
     * @param quantity  The quantity of the dish in the invoice.
     * @throws RuntimeException if an error occurs while adding the invoice detail.
     */
    public void addInvoiceDetail(int invoiceID, int dishID, int quantity) {
        String query = "INSERT INTO [Invoice_Detail] (InvoiceID, DishID, Quantity) VALUES (?, ?, ?)";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, invoiceID);
            statement.setInt(2, dishID);
            statement.setInt(3, quantity);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding invoice detail.", e);
        }
    }

    /**
     * Retrieves a list of invoice details by invoice ID.
     *
     * @param invoiceID The ID of the invoice.
     * @return A list of InvoiceDetail objects representing details for the specified invoice.
     * @throws RuntimeException if an error occurs while loading invoice details by invoice ID.
     */
    public List<InvoiceDetail> getInvoiceDetailsByInvoiceID(int invoiceID) {
        List<InvoiceDetail> invoiceDetails = new ArrayList<>();

        String query = "SELECT * FROM [Invoice_Detail] WHERE InvoiceID = ?;";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, invoiceID);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int dishID = resultSet.getInt("DishID");
                    int quantity = resultSet.getInt("Quantity");

                    InvoiceDetail invoiceDetail = new InvoiceDetail(invoiceID, dishID, quantity);
                    invoiceDetails.add(invoiceDetail);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading invoice details by invoice ID.", e);
        }

        return invoiceDetails;
    }
    
    /**
    * Checks if a dish is existing in the Invoice_Detail for a specific invoice.
    *
    * @param invoiceID The ID of the invoice.
    * @param dishID    The ID of the dish to check.
    * @return true if the dish exists in the Invoice_Detail for the given invoice, false otherwise.
    * @throws RuntimeException if an error occurs while checking for the existence of the dish.
    */
   public boolean isExistingDishInInvoiceDetail(int invoiceID, int dishID) {
       String query = "SELECT COUNT(*) FROM [Invoice_Detail] WHERE InvoiceID = ? AND DishID = ?;";

       try (Connection connection = DbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

           statement.setInt(1, invoiceID);
           statement.setInt(2, dishID);

           try (ResultSet resultSet = statement.executeQuery()) {
               if (resultSet.next()) {
                   int count = resultSet.getInt(1);
                   return count > 0;
               }
           }
       } catch (SQLException e) {
           throw new RuntimeException("Error checking if the dish exists in Invoice_Detail.", e);
       }

       return false;
   }
   
    /**
     * Updates the quantity of a dish in the Invoice_Detail for a specific invoice.
     *
     * @param invoiceID The ID of the invoice.
     * @param dishID    The ID of the dish to update.
     * @param newQuantity The new quantity of the dish in the invoice.
     * @throws RuntimeException if an error occurs while updating the invoice detail.
     */
    public void updateInvoiceDetail(int invoiceID, int dishID, int newQuantity) {
        String query = "UPDATE [Invoice_Detail] SET Quantity += ? " +
                       "WHERE InvoiceID = ? AND DishID = ?";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, newQuantity);
            statement.setInt(2, invoiceID);
            statement.setInt(3, dishID);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating invoice detail.", e);
        }
    }
}
