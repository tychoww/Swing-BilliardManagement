package DAO;

import DTO.Invoice;
import DTO.RevenueStat;
import com.sun.jdi.connect.spi.Connection;
import java.time.LocalDateTime;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) class for managing revenue statistics entities.
 * This class provides an empty shell without any methods.
 * It follows the singleton pattern to ensure a single instance.
 * 
 * @author Tychow
 */
public class RevenueStatDAO {
    private static RevenueStatDAO instance;

    /**
     * Gets the singleton instance of RevenueStatDAO.
     *
     * @return The singleton instance of RevenueStatDAO.
     */
    public static RevenueStatDAO getInstance() {
        return instance == null ? (instance = new RevenueStatDAO()) : instance;
    }

    /**
     * Private constructor to enforce singleton pattern.
     */
    private RevenueStatDAO() { }
    
    /**
     * Retrieves overall revenue statistics based on the specified date range from the database.
     *
     * @param dateCheckin  The start date for the date range.
     * @param dateCheckout The end date for the date range.
     * @return A list of RevenueStatDTO objects representing overall revenue statistics.
     * @throws RuntimeException if an error occurs while retrieving revenue statistics.
     */
    public List<RevenueStat> getOverallStatisticsByDate(String dateCheckin, String dateCheckout) {
        String query = "SELECT t.TableName AS [Tên bàn], inv.DateCheckin AS [Ngày vào], "
                + "inv.DateCheckout AS [Ngày ra], inv.TotalPrice AS [Tổng tiền] "
                + "FROM [Invoice] AS inv "
                + "JOIN [Table] AS t ON inv.TableID = t.TableID "
                + "WHERE inv.Status = 1 AND inv.DateCheckin >= ? AND inv.DateCheckout <= ?";

        List<RevenueStat> revenueStatsList = new ArrayList<>();

        try (java.sql.Connection connection = DbHelper.getConnection(); 
                PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, dateCheckin);
            statement.setString(2, dateCheckout);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String tableName = resultSet.getString("Tên bàn");
                    LocalDateTime checkinDate = resultSet.getTimestamp("Ngày vào").toLocalDateTime();
                    LocalDateTime checkoutDate = resultSet.getTimestamp("Ngày ra").toLocalDateTime();
                    double totalPrice = resultSet.getDouble("Tổng tiền");

                    RevenueStat revenueStat = new RevenueStat(tableName, checkinDate, checkoutDate, totalPrice);
                    revenueStatsList.add(revenueStat);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading invoice list.", e);
        }

        return revenueStatsList;
    }
}
