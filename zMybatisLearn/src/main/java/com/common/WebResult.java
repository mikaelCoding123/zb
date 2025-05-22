package com.common;

import com.enumcode.CodeEnum;


import java.io.Serializable;

public class WebResult implements Serializable {
    private String code = CodeEnum.SUCCESS.getCode();
    private String msg = CodeEnum.SUCCESS.getMsg();
    private Object data = null;
    private boolean show = false;

    public WebResult() {
    }

    public WebResult(CodeEnum u) {
        this.code = u.getCode();
        this.msg = u.getMsg();
        this.show=u.isFlag();
    }

    public WebResult(String msg,boolean flag) {
        this.msg = msg;
        this.show=flag;
    }

    public WebResult(Object o) {
        this.data = o;
    }

    public WebResult(CodeEnum u, Object o) {
        this.code = u.getCode();
        this.msg = u.getMsg();
        this.data = o;
        this.show=u.isFlag();
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

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "WebResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", show=" + show +
                '}';
    }
}
