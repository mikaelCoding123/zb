package com.response;

import java.io.Serializable;

public class ServiceResult implements Serializable {
    private static final long serialVersionUID = -2316358134496498970L;
    private String resultCode = "000000";
    private String resultMsg = "";
    private Object resultObj = null;

    public ServiceResult() {
    }

    public ServiceResult(String message) {
        this.resultMsg = message;
    }

    public ServiceResult(String code, String message) {
        this.resultCode = code;
        this.resultMsg = message;
    }

    public ServiceResult(String code, String message, Object ret_obj) {
        this.resultCode = code;
        this.resultMsg = message;
        this.resultObj = ret_obj;
    }

    public ServiceResult(Object ret_obj) {
        this.resultObj = ret_obj;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResultObj() {
        return this.resultObj;
    }

    public void setResultObj(Object resultObj) {
        this.resultObj = resultObj;
    }
}
