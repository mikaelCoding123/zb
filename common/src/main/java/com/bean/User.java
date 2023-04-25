package com.bean;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private final static long serialVersionUID = 1L;
    private String pokid;
    private String username;
    private String password;
    private List pc;

    public User() {
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

    public List<String> getPc() {
        return pc;
    }

    public void setPc(List<String> pc) {
        this.pc = pc;
    }
}
