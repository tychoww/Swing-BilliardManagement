package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Represents an Account entity with email, password, and role attributes.
 * This class provides constructors for creating Account objects and a constructor for creating
 * an Account object from a ResultSet obtained from the database.
 * It also includes getter and setter methods for accessing and modifying the attributes.
 * 
 * @author https://github.com/tychoww
 * @see ResultSet
 * @see SQLException
 */
public class Account {
    private String Email;
    private String PassWord;
    private String Role;

    /**
     * Constructs an Account object with the specified email, password, and role.
     *
     * @param email    The email of the account.
     * @param passWord The password of the account.
     * @param role     The role of the account.
     */
    public Account(String email, String passWord, String role) {
        this.Email = email;
        this.PassWord = passWord;
        this.Role = role;
    }

    /**
     * Constructs an Account object from the provided ResultSet obtained from the database.
     * This constructor is used for creating Account objects based on database query results.
     *
     * @param resultSet The ResultSet containing account data.
     * @throws SQLException if an SQL exception occurs while retrieving data from the ResultSet.
     */
    public Account(ResultSet resultSet) throws SQLException {
        this.Email = resultSet.getString("Email");
        this.PassWord = resultSet.getString("PassWord");
        this.Role = resultSet.getString("Role");
    }

    /**
     * Gets the email of the account.
     *
     * @return The email of the account.
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Sets the email of the account.
     *
     * @param email The new email for the account.
     */
    public void setEmail(String email) {
        this.Email = email;
    }

    /**
     * Gets the password of the account.
     *
     * @return The password of the account.
     */
    public String getPassWord() {
        return PassWord;
    }

    /**
     * Sets the password of the account.
     *
     * @param passWord The new password for the account.
     */
    public void setPassWord(String passWord) {
        this.PassWord = passWord;
    }

    /**
     * Gets the role of the account.
     *
     * @return The role of the account.
     */
    public String getRole() {
        return Role;
    }

    /**
     * Sets the role of the account.
     *
     * @param role The new role for the account.
     */
    public void setRole(String role) {
        this.Role = role;
    }
}
