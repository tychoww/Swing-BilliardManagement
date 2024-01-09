package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Category {
    private int CategoryID;
    private String CategoryName;

    public Category(int categoryID, String categoryName) {
        this.CategoryID = categoryID;
        this.CategoryName = categoryName;
    }

    // Constructor for creating a Category object from a ResultSet
    public Category(ResultSet resultSet) throws SQLException {
        this.CategoryID = resultSet.getInt("CategoryID");
        this.CategoryName = resultSet.getString("CategoryName");
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        this.CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        this.CategoryName = categoryName;
    }
}
