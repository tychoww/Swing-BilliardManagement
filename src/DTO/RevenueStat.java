package DTO;

import java.time.LocalDateTime;

/**
 * Represents a Data Transfer Object for revenue statistics.
 * It includes attributes such as TableName, DateCheckin, DateCheckout, and TotalPrice.
 * This class is used for transferring revenue-related data between layers.
 * 
 * @author https://github.com/tychoww
 * @see LocalDateTime
 */
public class RevenueStat {
    private String TableName;
    private LocalDateTime DateCheckin;
    private LocalDateTime DateCheckout;
    private double TotalPrice;

    /**
     * Constructs a RevenueStat object with the specified attributes.
     *
     * @param tableName    The name of the table associated with the revenue.
     * @param dateCheckin  The date and time when the revenue started.
     * @param dateCheckout The date and time when the revenue ended.
     * @param totalPrice   The total revenue amount.
     */
    public RevenueStat(String tableName, LocalDateTime dateCheckin, LocalDateTime dateCheckout, double totalPrice) {
        this.TableName = tableName;
        this.DateCheckin = dateCheckin;
        this.DateCheckout = dateCheckout;
        this.TotalPrice = totalPrice;
    }

    /**
     * Gets the name of the table associated with the revenue.
     *
     * @return The table name.
     */
    public String getTableName() {
        return TableName;
    }

    /**
     * Gets the date and time when the revenue started.
     *
     * @return The check-in date and time.
     */
    public LocalDateTime getDateCheckin() {
        return DateCheckin;
    }

    /**
     * Gets the date and time when the revenue ended.
     *
     * @return The check-out date and time.
     */
    public LocalDateTime getDateCheckout() {
        return DateCheckout;
    }

    /**
     * Gets the total revenue amount.
     *
     * @return The total revenue amount.
     */
    public double getTotalPrice() {
        return TotalPrice;
    }
}
