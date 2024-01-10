package DAO;

import DTO.Table;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Data Access Object (DAO) for handling operations related to the 'Table' entity.
 * This class provides methods for retrieving and modifying table information in the database.
 * It utilizes the singleton pattern to ensure a single instance of the class.
 *
 * @author https://github.com/tychoww
 */
public class TableDAO {
    private static TableDAO instance;
    public static int TableWidth = 100;
    public static int TableHeight = 100;

    /**
     * Gets the singleton instance of TableDAO.
     *
     * @return The singleton instance of TableDAO.
     */
    public static TableDAO getInstance() {
        return instance == null ? (instance = new TableDAO()) : instance;
    }

    /**
     * Private constructor to enforce singleton pattern.
     */
    private TableDAO() { }

    /**
     * Retrieves a list of all tables from the database.
     *
     * @return A list of Table objects representing tables in the database.
     * @throws RuntimeException if an error occurs while loading table information.
     */
    public List<Table> getAllTableList() {
        List<Table> tableList = new ArrayList<>();

        String query = "SELECT * FROM [Table];";

        try (Connection connection = DbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int tableID = resultSet.getInt("TableID");
                String tableName = resultSet.getString("TableName");
                String status = resultSet.getString("Status");
                double price = resultSet.getDouble("Price");

                Table table = new Table(tableID, tableName, status, price);
                tableList.add(table);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading table list.", e);
        }

        return tableList;
    }

    /**
     * Changes the status of a table in the database.
     *
     * @param tableID   The ID of the table to be updated.
     * @param newStatus The new status to be set for the table.
     * @throws RuntimeException if an error occurs while changing the table status.
     */
    public void changeStatusTable(int tableID, String newStatus) {
        String query = "UPDATE [Table] SET Status = ? WHERE TableID = ?";

        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, newStatus);
            statement.setInt(2, tableID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error changing table status.", e);
        }
    }
}
