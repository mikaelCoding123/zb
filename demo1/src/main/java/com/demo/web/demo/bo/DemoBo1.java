package com.demo.web.demo.bo;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @NotNull：不能为null，但可以为empty，用在基本类型上
 * @NotEmpty：不能为null，而且长度必须大于0，用在集合类上面
 * @NotBlank：只能作用在String上，不能为null，而且调用trim()后，长度必须大于0
 */
public class DemoBo1 implements Serializable {
    @NotBlank(message = "pokid 不能为空")
    private String pokid;
    @Size(min = 3,max = 10,message = "username必须在3~10之间")
    private String username;
    @NotNull(message = "password 不能为空")
    private String password;

    @NotNull
    private int age;
    //引用类型
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
