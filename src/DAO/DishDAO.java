package DAO;

import DTO.Dish;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Data Access Object (DAO) for handling operations related to the 'Dish' entity.
 * This class provides methods for retrieving all dishes and getting dishes by category ID.
 * It utilizes the singleton pattern to ensure a single instance of the class.
 * 
 * @author https://github.com/tychoww
 */
public class DishDAO {
    private static DishDAO instance;

    /**
     * Gets the singleton instance of DishDAO.
     *
     * @return The singleton instance of DishDAO.
     */
    public static DishDAO getInstance() {
        return instance == null ? (instance = new DishDAO()) : instance;
    }

    /**
     * Private constructor to enforce singleton pattern.
     */
    private DishDAO() { }

    /**
     * Retrieves a list of all dishes in the system.
     *
     * @return A list of Dish objects representing all dishes.
     * @throws RuntimeException if an error occurs while loading the dish list.
     */
    public List<Dish> getAllDishList() {
        List<Dish> dishList = new ArrayList<>();

        String query = "SELECT * FROM [Dish];";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                // Extracting dish data from the result set
                int dishID = resultSet.getInt("DishID");
                String dishName = resultSet.getString("DishName");
                double price = resultSet.getDouble("Price");
                int categoryID = resultSet.getInt("CategoryID");

                // Creating a Dish object and adding it to the list
                Dish dish = new Dish(dishID, dishName, price, categoryID);
                dishList.add(dish);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading dish list.", e);
        }

        return dishList;
    }

    /**
     * Retrieves a list of dishes based on the specified category ID.
     *
     * @param categoryID The ID of the category for which to retrieve dishes.
     * @return A list of Dish objects representing dishes in the specified category.
     * @throws RuntimeException if an error occurs while loading dish list by category ID.
     */
    public List<Dish> getDishListByCategoryID(int categoryID) {
        List<Dish> dishList = new ArrayList<>();
        String query = "SELECT * FROM [Dish] WHERE CategoryID = ?";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, categoryID);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Extracting dish data from the result set
                    int dishID = resultSet.getInt("DishID");
                    String dishName = resultSet.getString("DishName");
                    double price = resultSet.getDouble("Price");

                    // Creating a Dish object and adding it to the list
                    Dish dish = new Dish(dishID, dishName, price, categoryID);
                    dishList.add(dish);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading dish list.", e);
        }

        return dishList;
    }
    
    public void insertNewDish(String dishName, double price, int categoryID) {
        // Check if the provided categoryID exists in the Category table
        if (!isCategoryExists(categoryID)) {
            throw new RuntimeException("Invalid CategoryID. Category does not exist.");
        }

        String query = "INSERT INTO [Dish] (DishName, Price, CategoryID) VALUES (?, ?, ?)";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, dishName);
            statement.setDouble(2, price);
            statement.setInt(3, categoryID);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting a new dish.", e);
        }
    }
   
    private boolean isCategoryExists(int categoryID) {
        String query = "SELECT COUNT(*) FROM Category WHERE CategoryID = ?";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, categoryID);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // If count is greater than 0, the category exists
                }
            }
        } catch (SQLException e) {
            // Handle any SQL exception (e.g., log or throw a custom exception)
            e.printStackTrace();
        }

        return false; // Default to false if an exception occurs
    }
   
    public void deleteDishByID(int dishID) {
        String query = "DELETE FROM [Dish] WHERE DishID = ?";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, dishID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting dish by ID.", e);
        }
    }
    
    /**
     * Updates an existing dish in the database.
     *
     * @param dishID      The ID of the dish to update.
     * @param dishName    The new name for the dish.
     * @param price       The new price for the dish.
     * @param categoryID  The new category ID for the dish.
     * @throws RuntimeException if an error occurs while updating the dish.
     */
    public void updateDish(int dishID, String dishName, double price, int categoryID) {
        String query = "UPDATE [Dish] SET DishName = ?, Price = ?, CategoryID = ? WHERE DishID = ?";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, dishName);
            statement.setDouble(2, price);
            statement.setInt(3, categoryID);
            statement.setInt(4, dishID);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating the dish.", e);
        }
    }
    
    public List<Dish> searchDishByName(String dishName) {
        List<Dish> result = new ArrayList<>();
        String query = "SELECT * FROM [Dish] WHERE DishName LIKE ?";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "%" + dishName + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int dishID = resultSet.getInt("DishID");
                    String name = resultSet.getString("DishName");
                    double price = resultSet.getDouble("Price");
                    int categoryID = resultSet.getInt("CategoryID");

                    Dish dish = new Dish(dishID, name, price, categoryID);
                    result.add(dish);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error searching dishes by name.", e);
        }

        return result;
    }
}
