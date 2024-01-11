/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.InvoiceDetailTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tychow
 */
public class InvoiceDetailTableDAO {
    private static InvoiceDetailTableDAO instance;

    /**
     * Gets the singleton instance of InvoiceDetailDAO.
     *
     * @return The singleton instance of InvoiceDetailDAO.
     */
    public static InvoiceDetailTableDAO getInstance() {
        return instance == null ? (instance = new InvoiceDetailTableDAO()) : instance;
    }

    /**
     * Private constructor to enforce singleton pattern.
     */
    private InvoiceDetailTableDAO() { }

    public List<InvoiceDetailTable> getListInvoiceDetailByTableID(int tableID) {
        List<InvoiceDetailTable> listInvoiceDetailTable = new ArrayList<>();
        String query = "SELECT D.DishName, INVD.Quantity, D.Price, D.Price * INVD.Quantity as 'TotalPrice'" +
                " FROM [Dish] AS D, [Invoice_Detail] AS INVD, [Invoice] AS INV" +
                " WHERE INVD.InvoiceID = INV.InvoiceID AND D.DishID = INVD.DishID AND INV.Status = 0 AND INV.TableID = ?";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, tableID);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String dishName = resultSet.getString("DishName");
                    int quantity = resultSet.getInt("Quantity");
                    double price = resultSet.getDouble("Price");
                    double totalPrice = resultSet.getDouble("TotalPrice");

                    InvoiceDetailTable invoiceDetailTable = new InvoiceDetailTable(dishName, quantity, price, totalPrice);
                    listInvoiceDetailTable.add(invoiceDetailTable);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading invoice details by invoice ID.", e);
        }
        return listInvoiceDetailTable;
    }
}
