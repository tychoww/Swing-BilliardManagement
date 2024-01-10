package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Represents a Dish entity with DishID, DishName, Price, and CategoryID attributes.
 * This class provides constructors for creating Dish objects and a constructor for creating
 * a Dish object from a ResultSet obtained from the database.
 * It also includes getter and setter methods for accessing and modifying the attributes.
 * 
 * @author https://github.com/tychoww
 * @see ResultSet
 * @see SQLException
 */
public class Dish {
    private int DishID;
    private String DishName;
    private double Price;
    private int CategoryID;

    /**
     * Constructs a Dish object with the specified dish ID, dish name, price, and category ID.
     *
     * @param dishID     The unique identifier for the dish.
     * @param dishName   The name of the dish.
     * @param price      The price of the dish.
     * @param categoryID The unique identifier for the category to which the dish belongs.
     */
    public Dish(int dishID, String dishName, double price, int categoryID) {
        this.DishID = dishID;
        this.DishName = dishName;
        this.Price = price;
        this.CategoryID = categoryID;
    }

    /**
     * Constructs a Dish object from the provided ResultSet obtained from the database.
     * This constructor is used for creating Dish objects based on database query results.
     *
     * @param resultSet The ResultSet containing dish data.
     * @throws SQLException if an SQL exception occurs while retrieving data from the ResultSet.
     */
    public Dish(ResultSet resultSet) throws SQLException {
        this.DishID = resultSet.getInt("DishID");
        this.DishName = resultSet.getString("DishName");
        this.Price = resultSet.getDouble("Price");
        this.CategoryID = resultSet.getInt("CategoryID");
    }

    /**
     * Gets the dish ID.
     *
     * @return The dish ID.
     */
    public int getDishID() {
        return DishID;
    }

    /**
     * Sets the dish ID.
     *
     * @param dishID The new dish ID.
     */
    public void setDishID(int dishID) {
        this.DishID = dishID;
    }

    /**
     * Gets the dish name.
     *
     * @return The dish name.
     */
    public String getDishName() {
        return DishName;
    }

    /**
     * Sets the dish name.
     *
     * @param dishName The new dish name.
     */
    public void setDishName(String dishName) {
        this.DishName = dishName;
    }

    /**
     * Gets the price of the dish.
     *
     * @return The price of the dish.
     */
    public double getPrice() {
        return Price;
    }

    /**
     * Sets the price of the dish.
     *
     * @param price The new price of the dish.
     */
    public void setPrice(double price) {
        this.Price = price;
    }

    /**
     * Gets the category ID to which the dish belongs.
     *
     * @return The category ID.
     */
    public int getCategoryID() {
        return CategoryID;
    }

    /**
     * Sets the category ID to which the dish belongs.
     *
     * @param categoryID The new category ID.
     */
    public void setCategoryID(int categoryID) {
        this.CategoryID = categoryID;
    }
}
