package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Represents an Invoice entity with InvoiceID, CustomerID, TableID, DateCheckin, DateCheckout,
 * Status, and TotalPrice attributes. This class provides constructors for creating Invoice objects
 * and a constructor for creating an Invoice object from a ResultSet obtained from the database.
 * It also includes getter and setter methods for accessing and modifying the attributes.
 * 
 * @author https://github.com/tychoww
 * @see ResultSet
 * @see SQLException
 * @see LocalDateTime
 */
public class Invoice {
    private int InvoiceID;
    private int CustomerID;
    private int TableID;
    private LocalDateTime DateCheckin;
    private LocalDateTime DateCheckout;
    private int Status;
    private double TotalPrice;

    /**
     * Constructs an Invoice object with the specified invoice ID, customer ID, table ID,
     * check-in date, check-out date, status, and total price.
     *
     * @param invoiceID    The unique identifier for the invoice.
     * @param customerID   The unique identifier for the customer associated with the invoice.
     * @param tableID      The unique identifier for the table associated with the invoice.
     * @param dateCheckin  The date and time when the invoice was checked in.
     * @param dateCheckout The date and time when the invoice was checked out.
     * @param status       The status of the invoice.
     * @param totalPrice   The total price of the items in the invoice.
     */
    public Invoice(int invoiceID, int customerID, int tableID, LocalDateTime dateCheckin,
                   LocalDateTime dateCheckout, int status, double totalPrice) {
        this.InvoiceID = invoiceID;
        this.CustomerID = customerID;
        this.TableID = tableID;
        this.DateCheckin = dateCheckin;
        this.DateCheckout = dateCheckout;
        this.Status = status;
        this.TotalPrice = totalPrice;
    }

    /**
     * Constructs an Invoice object from the provided ResultSet obtained from the database.
     * This constructor is used for creating Invoice objects based on database query results.
     *
     * @param resultSet The ResultSet containing invoice data.
     * @throws SQLException if an SQL exception occurs while retrieving data from the ResultSet.
     */
    public Invoice(ResultSet resultSet) throws SQLException {
        this.InvoiceID = resultSet.getInt("InvoiceID");
        this.CustomerID = resultSet.getInt("CustomerID");
        this.TableID = resultSet.getInt("TableID");
        this.DateCheckin = resultSet.getTimestamp("DateCheckin").toLocalDateTime();
        this.DateCheckout = resultSet.getObject("DateCheckout") != null ?
                resultSet.getTimestamp("DateCheckout").toLocalDateTime() : null;
        this.Status = resultSet.getInt("Status");
        this.TotalPrice = resultSet.getDouble("TotalPrice");
    }

    /**
     * Gets the invoice ID.
     *
     * @return The invoice ID.
     */
    public int getInvoiceID() {
        return InvoiceID;
    }

    /**
     * Sets the invoice ID.
     *
     * @param invoiceID The new invoice ID.
     */
    public void setInvoiceID(int invoiceID) {
        this.InvoiceID = invoiceID;
    }

    /**
     * Gets the customer ID associated with the invoice.
     *
     * @return The customer ID.
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /**
     * Sets the customer ID associated with the invoice.
     *
     * @param customerID The new customer ID.
     */
    public void setCustomerID(int customerID) {
        this.CustomerID = customerID;
    }

    /**
     * Gets the table ID associated with the invoice.
     *
     * @return The table ID.
     */
    public int getTableID() {
        return TableID;
    }

    /**
     * Sets the table ID associated with the invoice.
     *
     * @param tableID The new table ID.
     */
    public void setTableID(int tableID) {
        this.TableID = tableID;
    }

    /**
     * Gets the date and time when the invoice was checked in.
     *
     * @return The check-in date and time.
     */
    public LocalDateTime getDateCheckin() {
        return DateCheckin;
    }

    /**
     * Sets the date and time when the invoice was checked in.
     *
     * @param dateCheckin The new check-in date and time.
     */
    public void setDateCheckin(LocalDateTime dateCheckin) {
        this.DateCheckin = dateCheckin;
    }

    /**
     * Gets the date and time when the invoice was checked out.
     *
     * @return The check-out date and time.
     */
    public LocalDateTime getDateCheckout() {
        return DateCheckout;
    }

    /**
     * Sets the date and time when the invoice was checked out.
     *
     * @param dateCheckout The new check-out date and time.
     */
    public void setDateCheckout(LocalDateTime dateCheckout) {
        this.DateCheckout = dateCheckout;
    }

    /**
     * Gets the status of the invoice.
     *
     * @return The status of the invoice.
     */
    public int getStatus() {
        return Status;
    }

    /**
     * Sets the status of the invoice.
     *
     * @param status The new status of the invoice.
     */
    public void setStatus(int status) {
        this.Status = status;
    }

    /**
     * Gets the total price of the items in the invoice.
     *
     * @return The total price.
     */
    public double getTotalPrice() {
        return TotalPrice;
    }

    /**
     * Sets the total price of the items in the invoice.
     *
     * @param totalPrice The new total price.
     */
    public void setTotalPrice(double totalPrice) {
        this.TotalPrice = totalPrice;
    }
}

