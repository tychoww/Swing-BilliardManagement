package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Invoice {
    private int InvoiceID;
    private int CustomerID;
    private int TableID;
    private String DateCheckin;
    private String DateCheckout;
    private int Status;
    private double TotalPrice;

    public Invoice(int invoiceID, int customerID, int tableID, String dateCheckin, String dateCheckout, int status, double totalPrice) {
        this.InvoiceID = invoiceID;
        this.CustomerID = customerID;
        this.TableID = tableID;
        this.DateCheckin = dateCheckin;
        this.DateCheckout = dateCheckout;
        this.Status = status;
        this.TotalPrice = totalPrice;
    }

    public Invoice(ResultSet resultSet) throws SQLException {
        this.InvoiceID = resultSet.getInt("InvoiceID");
        this.CustomerID = resultSet.getInt("CustomerID");
        this.TableID = resultSet.getInt("TableID");
        this.DateCheckin = resultSet.getString("DateCheckin");
        this.DateCheckout = resultSet.getString("DateCheckout");
        this.Status = resultSet.getInt("Status");
        this.TotalPrice = resultSet.getDouble("TotalPrice");
    }

    public int getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.InvoiceID = invoiceID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        this.CustomerID = customerID;
    }

    public int getTableID() {
        return TableID;
    }

    public void setTableID(int tableID) {
        this.TableID = tableID;
    }

    public String getDateCheckin() {
        return DateCheckin;
    }

    public void setDateCheckin(String dateCheckin) {
        this.DateCheckin = dateCheckin;
    }

    public String getDateCheckout() {
        return DateCheckout;
    }

    public void setDateCheckout(String dateCheckout) {
        this.DateCheckout = dateCheckout;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        this.Status = status;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.TotalPrice = totalPrice;
    }
}
