package com.example.demo.dto;

public class User {
    private String UserName;
    private String ID;
    private String Password;
    private String Email;

    public String getUserName() {
        return UserName;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", ID='" + ID + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
