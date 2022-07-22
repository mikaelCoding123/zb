package com.demo.web.demo.bo;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class Child implements Serializable {
    @NotBlank(message = "child name 不能为空")
    private String name;
    @NotBlank(message = "child age 不能为空")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
