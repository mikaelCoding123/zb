package com.bean;

import java.io.Serializable;

public class User implements Serializable {
    private final static long serialVersionUID = 1L;
    private String userid;
    private String username;
    private String password;
    private String balance;//余额

    public User(String userid, String username, String password, String balance) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public User() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
