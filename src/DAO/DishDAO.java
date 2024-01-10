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
}
