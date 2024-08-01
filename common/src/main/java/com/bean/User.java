package com.bean;

import com.sun.deploy.util.OrderedHashSet;

import java.io.Serializable;

public class User implements Serializable {
    private final static long serialVersionUID = 1L;
    private String pokid;
    private String username;
    private String password;

    public User() {
    }

    public User(String s, String s1, String s2) {

    }


    public String getPokid() {
        return pokid;
    }

    public void setPokid(String pokid) {
        this.pokid = pokid;
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

    @Override
    public String toString() {
        return "User{" +
                "pokid='" + pokid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public OrderedHashSet getPc() {
        return null;
    }
}
