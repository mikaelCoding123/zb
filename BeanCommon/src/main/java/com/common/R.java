package com.common;

import java.io.Serializable;

public class R implements Serializable {
    private final static long serialVersionUID = 1L;
    private String code =CommonCode.code_200;
    private String msg= CommonMsg.SUCCESS;
    private  Object object=null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
