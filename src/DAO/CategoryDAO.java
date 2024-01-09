package DAO;

import DTO.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private static CategoryDAO instance;

    public static CategoryDAO getInstance() {
        return instance == null ? (instance = new CategoryDAO()) : instance;
    }

    private CategoryDAO() { }

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
}
