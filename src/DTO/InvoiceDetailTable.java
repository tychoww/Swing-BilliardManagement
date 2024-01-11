package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Represents an extended version of the InvoiceDetail entity with additional attributes for displaying in a table.
 * This class includes attributes such as DishName, Quantity, Price, and TotalPrice.
 *
 * @author https://github.com/tychoww
 * @see ResultSet
 * @see SQLException
 */
public class InvoiceDetailTable {
    private String DishName;
    private int Quantity;
    private double Price;
    private double TotalPrice;

    /**
     * Constructs an InvoiceDetailTable object with the specified dish name, quantity, price, and total price.
     *
     * @param dishName   The name of the dish.
     * @param quantity   The quantity of the dish.
     * @param price      The price of the dish.
     * @param totalPrice The total price for the quantity of the dish.
     */
    public InvoiceDetailTable(String dishName, int quantity, double price, double totalPrice) {
        this.DishName = dishName;
        this.Quantity = quantity;
        this.Price = price;
        this.TotalPrice = totalPrice;
    }

    /**
     * Constructs an InvoiceDetailTable object from the provided ResultSet obtained from the database.
     * This constructor is used for creating InvoiceDetailTable objects based on database query results.
     *
     * @param resultSet The ResultSet containing invoice detail data.
     * @throws SQLException if an SQL exception occurs while retrieving data from the ResultSet.
     */
    public InvoiceDetailTable(ResultSet resultSet) throws SQLException {
        this.DishName = resultSet.getString("DishName");
        this.Quantity = resultSet.getInt("Quantity");
        this.Price = resultSet.getDouble("Price");
        this.TotalPrice = resultSet.getDouble("TotalPrice");
    }

    /**
     * Gets the name of the dish.
     *
     * @return The dish name.
     */
    public String getDishName() {
        return DishName;
    }

    /**
     * Sets the name of the dish.
     *
     * @param dishName The new dish name.
     */
    public void setDishName(String dishName) {
        this.DishName = dishName;
    }

    /**
     * Gets the quantity of the dish.
     *
     * @return The quantity.
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * Sets the quantity of the dish.
     *
     * @param quantity The new quantity.
     */
    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }

    /**
     * Gets the price of the dish.
     *
     * @return The dish price.
     */
    public double getPrice() {
        return Price;
    }

    /**
     * Sets the price of the dish.
     *
     * @param price The new dish price.
     */
    public void setPrice(double price) {
        this.Price = price;
    }

    /**
     * Gets the total price for the quantity of the dish.
     *
     * @return The total price.
     */
    public double getTotalPrice() {
        return TotalPrice;
    }

    /**
     * Sets the total price for the quantity of the dish.
     *
     * @param totalPrice The new total price.
     */
    public void setTotalPrice(double totalPrice) {
        this.TotalPrice = totalPrice;
    }
}
