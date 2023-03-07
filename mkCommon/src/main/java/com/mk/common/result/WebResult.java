package com.mk.common.result;

import java.io.Serializable;

public class WebResult implements Serializable {

    private String code = "000000";
    private String msg = "";
    private Object data = null;

    public WebResult() {
    }

    /**
     * code = "000000"
     *
     * @param message
     */
    public WebResult(String message) {
        this.msg = message;
    }

    public WebResult(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    /**
     * code = "000000";
     * data = data
     *
     * @param data
     */
    public WebResult(Object data) {
        this.data = data;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
