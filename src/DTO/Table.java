package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Table {
    private int TableID;
    private String TableName;
    private String Status;
    private double Price;

    public Table(int tableID, String tableName, String status, double price) {
        this.TableID = tableID;
        this.TableName = tableName;
        this.Status = status;
        this.Price = price;
    }

    public Table(ResultSet resultSet) throws SQLException {
        this.TableID = resultSet.getInt("TableID");
        this.TableName = resultSet.getString("TableName");
        this.Status = resultSet.getString("Status");
        this.Price = resultSet.getDouble("Price");
    }

    public int getTableID() {
        return TableID;
    }

    public void setTableID(int tableID) {
        this.TableID = tableID;
    }

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String tableName) {
        this.TableName = tableName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }
    
    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        this.Price = price;
    }
}
