package com.solider.bean;


import java.io.Serializable;

public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public User() {
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private Integer getId() {
        return this.id;
    }

    private String getUsername() {
        return this.username;
    }

    private String getPassword() {
        return this.password;
    }

}
