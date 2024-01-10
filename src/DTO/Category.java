package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Represents a Category entity with CategoryID and CategoryName attributes.
 * This class provides constructors for creating Category objects and a constructor for creating
 * a Category object from a ResultSet obtained from the database.
 * It also includes getter and setter methods for accessing and modifying the attributes.
 * 
 * @author https://github.com/tychoww
 * @see ResultSet
 * @see SQLException
 */
public class Category {
    private int CategoryID;
    private String CategoryName;

    /**
     * Constructs a Category object with the specified category ID and category name.
     *
     * @param categoryID   The unique identifier for the category.
     * @param categoryName The name of the category.
     */
    public Category(int categoryID, String categoryName) {
        this.CategoryID = categoryID;
        this.CategoryName = categoryName;
    }

    /**
     * Constructs a Category object from the provided ResultSet obtained from the database.
     * This constructor is used for creating Category objects based on database query results.
     *
     * @param resultSet The ResultSet containing category data.
     * @throws SQLException if an SQL exception occurs while retrieving data from the ResultSet.
     */
    public Category(ResultSet resultSet) throws SQLException {
        this.CategoryID = resultSet.getInt("CategoryID");
        this.CategoryName = resultSet.getString("CategoryName");
    }

    /**
     * Gets the category ID.
     *
     * @return The category ID.
     */
    public int getCategoryID() {
        return CategoryID;
    }

    /**
     * Sets the category ID.
     *
     * @param categoryID The new category ID.
     */
    public void setCategoryID(int categoryID) {
        this.CategoryID = categoryID;
    }

    /**
     * Gets the category name.
     *
     * @return The category name.
     */
    public String getCategoryName() {
        return CategoryName;
    }

    /**
     * Sets the category name.
     *
     * @param categoryName The new category name.
     */
    public void setCategoryName(String categoryName) {
        this.CategoryName = categoryName;
    }
}