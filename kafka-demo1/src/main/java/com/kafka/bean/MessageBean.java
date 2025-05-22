package com.kafka.bean;

import java.io.Serializable;

public class MessageBean implements Serializable {
    private final static long serialVersionUID=1L;
    private String code;
    private Object object;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
