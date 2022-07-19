package com.demo.web.demo.bo;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class DemoBo1 implements Serializable {
    @NotNull
    private String pokid;
    @Size(min = 3,max = 10,message = "username必须在3~10之间")
    private String username;
    @NotNull
    private String password;


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
}
