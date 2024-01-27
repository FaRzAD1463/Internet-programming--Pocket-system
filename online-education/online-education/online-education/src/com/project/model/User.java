package com.project.model;
import java.io.Serializable;
public class User implements Serializable {
    private int id;
    private String username;
    private String password; // Consider encrypting this
    private String email;
    private int roleId; // This could be an enum in a more complex system

    // Constructors
    public User() {}

    public User(int id, String username, String password, String email, int roleId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleId = roleId;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
