package com.IDentifyMe.models;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Student implements Serializable{
    private String StudentID ;
    private String Name;
    private String Email;
    private String Password;

    public Student(String StudentID, String Name, String Email, String Password) {
        this.StudentID = StudentID;
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
    }

    public Student(ResultSet rs) throws SQLException {
        this.StudentID = rs.getString("StudentID");
        this.Name = rs.getString("Name");
        this.Email = rs.getString("Email");
        this.Password = rs .getString("Password");
    }

    public String getStudentID() {
        return this.StudentID;
    }
    public String getName() {
        return this.Name;
    }
    public String getEmail() {
        return this.Email;
    }
    public String getPassword() {
        return this.Password;
    }
    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public boolean validateAttributes() {
        if (StudentID == null || StudentID.isEmpty() || !StudentID.matches("[a-zA-Z]{3}[0-9]{4}/[0-9]{2}")) {
            return false;
        }
        if (Name == null || Name.isEmpty()) {
            return false;
        }
        if (Email == null || Email.isEmpty() || !Email.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+")) {
            return false;
        }
        if (Password == null || Password.isEmpty() || Password.length() < 8) {
            return false;
        }
        return true;
    }
}
