package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Represents a Customer entity with CustomerID, CustomerName, Address, and PhoneNumber attributes.
 * This class provides constructors for creating Customer objects and a constructor for creating
 * a Customer object from a ResultSet obtained from the database.
 * It also includes getter and setter methods for accessing and modifying the attributes.
 */
public class Customer {
    private int CustomerID;
    private String CustomerName;
    private String Address;
    private String PhoneNumber;

    /**
     * Constructs a Customer object with the specified customer ID, customer name, address, and phone number.
     *
     * @param customerID    The customer ID.
     * @param customerName  The customer name.
     * @param address       The address of the customer.
     * @param phoneNumber   The phone number of the customer.
     */
    public Customer(int customerID, String customerName, String address, String phoneNumber) {
        this.CustomerID = customerID;
        this.CustomerName = customerName;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
    }

    /**
     * Constructs a Customer object from the provided ResultSet obtained from the database.
     * This constructor is used for creating Customer objects based on database query results.
     *
     * @param resultSet The ResultSet containing customer data.
     * @throws SQLException if an SQL exception occurs while retrieving data from the ResultSet.
     */
    public Customer(ResultSet resultSet) throws SQLException {
        this.CustomerID = resultSet.getInt("CustomerID");
        this.CustomerName = resultSet.getString("CustomerName");
        this.Address = resultSet.getString("Address");
        this.PhoneNumber = resultSet.getString("PhoneNumber");
    }

    /**
     * Gets the customer ID.
     *
     * @return The customer ID.
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /**
     * Sets the customer ID.
     *
     * @param customerID The new customer ID.
     */
    public void setCustomerID(int customerID) {
        this.CustomerID = customerID;
    }

    /**
     * Gets the customer name.
     *
     * @return The customer name.
     */
    public String getCustomerName() {
        return CustomerName;
    }

    /**
     * Sets the customer name.
     *
     * @param customerName The new customer name.
     */
    public void setCustomerName(String customerName) {
        this.CustomerName = customerName;
    }

    /**
     * Gets the address of the customer.
     *
     * @return The address of the customer.
     */
    public String getAddress() {
        return Address;
    }

    /**
     * Sets the address of the customer.
     *
     * @param address The new address for the customer.
     */
    public void setAddress(String address) {
        this.Address = address;
    }

    /**
     * Gets the phone number of the customer.
     *
     * @return The phone number of the customer.
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * Sets the phone number of the customer.
     *
     * @param phoneNumber The new phone number for the customer.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }
}
