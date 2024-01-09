package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Dish {
    private int DishID;
    private String DishName;
    private double Price;
    private int CategoryID;

    public Dish(int dishID, String dishName, double price, int categoryID) {
        this.DishID = dishID;
        this.DishName = dishName;
        this.Price = price;
        this.CategoryID = categoryID;
    }

    public Dish(ResultSet resultSet) throws SQLException {
        this.DishID = resultSet.getInt("DishID");
        this.DishName = resultSet.getString("DishName");
        this.Price = resultSet.getDouble("Price");
        this.CategoryID = resultSet.getInt("CategoryID");
    }

    public int getDishID() {
        return DishID;
    }

    public void setDishID(int dishID) {
        this.DishID = dishID;
    }

    public String getDishName() {
        return DishName;
    }

    public void setDishName(String dishName) {
        this.DishName = dishName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        this.CategoryID = categoryID;
    }
}
