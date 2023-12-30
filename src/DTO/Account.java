package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
    private String Email;
    private String PassWord;
    private String Role;

    public Account(String email, String passWord, String role) {
        this.Email = email;
        this.PassWord = passWord;
        this.Role = role;
    }

    public Account(ResultSet resultSet) throws SQLException {
        this.Email = resultSet.getString("Email");
        this.PassWord = resultSet.getString("PassWord");
        this.Role = resultSet.getString("Role");
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        this.PassWord = passWord;
    }
    
    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        this.Role = role;
    }
}
