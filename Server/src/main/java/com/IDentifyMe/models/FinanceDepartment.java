package com.IDentifyMe.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;

public class FinanceDepartment {
    private int employeeID;
    private String name;
    private String email;
    private String password;

    // Constructor
    public FinanceDepartment(int employeeID, String name, String email, String password) {
        this.employeeID = employeeID;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public FinanceDepartment(ResultSet rs) throws SQLException {
        this.employeeID = rs.getInt("EmployeeID");
        this.name = rs.getString("Name");
        this.email = rs.getString("Email");
        this.password = rs .getString("Password");
    }

    public FinanceDepartment(JSONObject json) {
        this(
                json.getInt("employeeID"),
                json.getString("name"),
                json.getString("email"),
                json.getString("password"));
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("employeeID", this.employeeID);
        json.put("name", this.name);
        json.put("email", this.email);
        json.put("password", this.password);
        return json;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validateAttributes() {
        if (name == null || name.isEmpty()) {
            return false;
        }
        if (email == null || email.isEmpty() || !email.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+")) {
            return false;
        }
        if (password == null || password.isEmpty() || password.length() < 8) {
            return false;
        }
        return true;
    }
}
