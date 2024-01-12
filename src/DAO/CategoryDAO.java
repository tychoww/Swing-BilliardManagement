package DAO;

import DTO.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) class for managing Category entities.
 * This class provides methods to retrieve category data from the database.
 * It follows the singleton pattern to ensure a single instance.
 * 
 * @author https://github.com/tychoww
 */
public class CategoryDAO {
    private static CategoryDAO instance;

    /**
     * Gets the singleton instance of CategoryDAO.
     *
     * @return The singleton instance of CategoryDAO.
     */
    public static CategoryDAO getInstance() {
        return instance == null ? (instance = new CategoryDAO()) : instance;
    }

    /**
     * Private constructor to enforce singleton pattern.
     */
    private CategoryDAO() { }

    /**
     * Retrieves a list of all categories from the database.
     *
     * @return A list of Category objects representing categories.
     * @throws RuntimeException if an error occurs while loading category data.
     */
    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();

        String query = "SELECT * FROM [Category];";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int categoryID = resultSet.getInt("CategoryID");
                String categoryName = resultSet.getString("CategoryName");

                Category category = new Category(categoryID, categoryName);
                categoryList.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading category list.", e);
        }

        return categoryList;
    }
    
    /**
     * Finds and retrieves a category by its ID from the database.
     *
     * @param categoryId The ID of the category to retrieve.
     * @return The Category object corresponding to the specified ID, or null if not found.
     * @throws RuntimeException if an error occurs while loading category data.
     */
    public Category findCategoryById(int categoryId) {
        String query = "SELECT * FROM [Category] WHERE CategoryID = ?;";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, categoryId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Category(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding category by ID.", e);
        }

        return null; // Return null if category with specified ID is not found
    }
}
