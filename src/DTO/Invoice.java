package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Invoice {
    private int InvoiceID;
    private int CustomerID;
    private int TableID;
    private LocalDateTime DateCheckin;
    private LocalDateTime DateCheckout;
    private int Status;
    private double TotalPrice;

    public Invoice(int invoiceID, int customerID, int tableID, LocalDateTime dateCheckin, LocalDateTime dateCheckout, int status, double totalPrice) {
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
        this.DateCheckin = resultSet.getTimestamp("DateCheckin").toLocalDateTime();
        this.DateCheckout = resultSet.getTimestamp("DateCheckout").toLocalDateTime();
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

    public LocalDateTime getDateCheckin() {
        return DateCheckin;
    }

    public void setDateCheckin(LocalDateTime dateCheckin) {
        this.DateCheckin = dateCheckin;
    }

    public LocalDateTime getDateCheckout() {
        return DateCheckout;
    }

    public void setDateCheckout(LocalDateTime dateCheckout) {
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

