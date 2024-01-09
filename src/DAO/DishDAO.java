package DAO;

import DTO.Dish;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DishDAO {
    private static DishDAO instance;

    public static DishDAO getInstance() {
        return instance == null ? (instance = new DishDAO()) : instance;
    }

    private DishDAO() { }

    public List<Dish> getAllDishList() {
        List<Dish> dishList = new ArrayList<>();

        String query = "SELECT * FROM [Dish];";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int dishID = resultSet.getInt("DishID");
                String dishName = resultSet.getString("DishName");
                double price = resultSet.getDouble("Price");
                int categoryID = resultSet.getInt("CategoryID");

                Dish dish = new Dish(dishID, dishName, price, categoryID);
                dishList.add(dish);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading dish list.", e);
        }

        return dishList;
    }
    
    public List<Dish> getDishListByCategoryID(int categoryID) {
        List<Dish> dishList = new ArrayList<>();
        String query = "SELECT * FROM [Dish] WHERE CategoryID = ?";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, categoryID);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int dishID = resultSet.getInt("DishID");
                    String dishName = resultSet.getString("DishName");
                    double price = resultSet.getDouble("Price");

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
