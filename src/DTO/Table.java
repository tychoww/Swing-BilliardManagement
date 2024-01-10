package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Represents a Table entity with TableID, TableName, Status, and Price attributes.
 * This class provides constructors for creating Table objects and a constructor for creating
 * a Table object from a ResultSet obtained from the database. It also includes
 * getter and setter methods for accessing and modifying the attributes.
 *
 * @author https://github.com/tychoww
 * @see ResultSet
 * @see SQLException
 */
public class Table {
    private int TableID;
    private String TableName;
    private String Status;
    private double Price;

    /**
     * Constructs a Table object with the specified table ID, table name, status, and price.
     *
     * @param tableID   The unique identifier for the table.
     * @param tableName The name of the table.
     * @param status    The status of the table (e.g., occupied, available).
     * @param price     The price associated with the table.
     */
    public Table(int tableID, String tableName, String status, double price) {
        this.TableID = tableID;
        this.TableName = tableName;
        this.Status = status;
        this.Price = price;
    }

    /**
     * Constructs a Table object from the provided ResultSet obtained from the database.
     * This constructor is used for creating Table objects based on database query results.
     *
     * @param resultSet The ResultSet containing table data.
     * @throws SQLException if an SQL exception occurs while retrieving data from the ResultSet.
     */
    public Table(ResultSet resultSet) throws SQLException {
        this.TableID = resultSet.getInt("TableID");
        this.TableName = resultSet.getString("TableName");
        this.Status = resultSet.getString("Status");
        this.Price = resultSet.getDouble("Price");
    }

    /**
     * Gets the table ID.
     *
     * @return The table ID.
     */
    public int getTableID() {
        return TableID;
    }

    /**
     * Sets the table ID.
     *
     * @param tableID The new table ID.
     */
    public void setTableID(int tableID) {
        this.TableID = tableID;
    }

    /**
     * Gets the name of the table.
     *
     * @return The table name.
     */
    public String getTableName() {
        return TableName;
    }

    /**
     * Sets the name of the table.
     *
     * @param tableName The new table name.
     */
    public void setTableName(String tableName) {
        this.TableName = tableName;
    }

    /**
     * Gets the status of the table.
     *
     * @return The table status.
     */
    public String getStatus() {
        return Status;
    }

    /**
     * Sets the status of the table.
     *
     * @param status The new table status.
     */
    public void setStatus(String status) {
        this.Status = status;
    }

    /**
     * Gets the price associated with the table.
     *
     * @return The table price.
     */
    public double getPrice() {
        return Price;
    }

    /**
     * Sets the price associated with the table.
     *
     * @param price The new table price.
     */
    public void setPrice(double price) {
        this.Price = price;
    }
}
