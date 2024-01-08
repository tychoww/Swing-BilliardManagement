package DAO;

import DTO.Invoice;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InvoiceDAO {
    private static InvoiceDAO instance;

    public static InvoiceDAO getInstance() {
        return instance == null ? (instance = new InvoiceDAO()) : instance;
    }

    private InvoiceDAO() { }

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

    public List<Invoice> getAllInvoiceList() {
        List<Invoice> invoiceList = new ArrayList<>();

        String query = "SELECT * FROM [Invoice];";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int invoiceID = resultSet.getInt("InvoiceID");
                int customerID = resultSet.getInt("CustomerID");
                int tableID = resultSet.getInt("TableID");
                String dateCheckin = resultSet.getString("DateCheckin");
                String dateCheckout = resultSet.getString("DateCheckout");
                int status = resultSet.getInt("Status");
                double totalPrice = resultSet.getDouble("TotalPrice");

                Invoice invoice = new Invoice(invoiceID, customerID, tableID, dateCheckin, dateCheckout, status, totalPrice);
                invoiceList.add(invoice);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading invoice list.", e);
        }

        return invoiceList;
    }
    
    public List<Invoice> getUnpaidInvoiceByTableID(int tableID) {
        List<Invoice> invoiceList = new ArrayList<>();

        String query = "SELECT * FROM [Invoice] WHERE TableID = ? AND Status=0;";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, tableID);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int invoiceID = resultSet.getInt("InvoiceID");
                    int customerID = resultSet.getInt("CustomerID");
                    String dateCheckin = resultSet.getString("DateCheckin");
                    String dateCheckout = resultSet.getString("DateCheckout");
                    int status = resultSet.getInt("Status");
                    double totalPrice = resultSet.getDouble("TotalPrice");

                    Invoice invoice = new Invoice(invoiceID, customerID, tableID, dateCheckin, dateCheckout, status, totalPrice);
                    invoiceList.add(invoice);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading invoices by tableID.", e);
        }

        return invoiceList;
    }
}
