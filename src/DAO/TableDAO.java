/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Table;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Tychow
 */
public class TableDAO {
    private static TableDAO instance;
    public static int TableWidth = 100;
    public static int TableHeight = 100;

    public static TableDAO getInstance() {
        return instance == null ? (instance = new TableDAO()) : instance;
    }
   
    private TableDAO() { }
    
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
}
