package com.demo.web.demo.bo;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;

public class DemoBo1 implements Serializable {
    @NotBlank(message = "pokid 不能为空")
    private String pokid;
    @Size(min = 3,max = 10,message = "username必须在3~10之间")
    private String username;
    @NotNull
    private String password;

    @NotNull
    private int age;

    @Valid
    private ArrayList<Child> list;

    public ArrayList<Child> getList() {
        return list;
    }

    public void setList(ArrayList<Child> list) {
        this.list = list;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
