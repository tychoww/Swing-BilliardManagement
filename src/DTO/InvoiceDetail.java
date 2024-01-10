package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Represents an Invoice Detail entity with InvoiceID, DishID, and Quantity attributes.
 * This class provides constructors for creating InvoiceDetail objects and a constructor for creating
 * an InvoiceDetail object from a ResultSet obtained from the database. It also includes
 * getter and setter methods for accessing and modifying the attributes.
 *
 * @author https://github.com/tychoww
 * @see ResultSet
 * @see SQLException
 */
public class InvoiceDetail {
    private int InvoiceID;
    private int DishID;
    private int Quantity;

    /**
     * Constructs an InvoiceDetail object with the specified invoice ID, dish ID, and quantity.
     *
     * @param invoiceID The unique identifier for the invoice associated with the detail.
     * @param dishID    The unique identifier for the dish associated with the detail.
     * @param quantity  The quantity of the dish in the detail.
     */
    public InvoiceDetail(int invoiceID, int dishID, int quantity) {
        this.InvoiceID = invoiceID;
        this.DishID = dishID;
        this.Quantity = quantity;
    }

    /**
     * Constructs an InvoiceDetail object from the provided ResultSet obtained from the database.
     * This constructor is used for creating InvoiceDetail objects based on database query results.
     *
     * @param resultSet The ResultSet containing invoice detail data.
     * @throws SQLException if an SQL exception occurs while retrieving data from the ResultSet.
     */
    public InvoiceDetail(ResultSet resultSet) throws SQLException {
        this.InvoiceID = resultSet.getInt("InvoiceID");
        this.DishID = resultSet.getInt("DishID");
        this.Quantity = resultSet.getInt("Quantity");
    }

    /**
     * Gets the invoice ID associated with the detail.
     *
     * @return The invoice ID.
     */
    public int getInvoiceID() {
        return InvoiceID;
    }

    /**
     * Sets the invoice ID associated with the detail.
     *
     * @param invoiceID The new invoice ID.
     */
    public void setInvoiceID(int invoiceID) {
        this.InvoiceID = invoiceID;
    }

    /**
     * Gets the dish ID associated with the detail.
     *
     * @return The dish ID.
     */
    public int getDishID() {
        return DishID;
    }

    /**
     * Sets the dish ID associated with the detail.
     *
     * @param dishID The new dish ID.
     */
    public void setDishID(int dishID) {
        this.DishID = dishID;
    }

    /**
     * Gets the quantity of the dish in the detail.
     *
     * @return The quantity.
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * Sets the quantity of the dish in the detail.
     *
     * @param quantity The new quantity.
     */
    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }
}
