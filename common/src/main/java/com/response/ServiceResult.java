package com.response;

import javax.jws.Oneway;
import java.io.Serializable;

public class ServiceResult implements Serializable {
    private static final long serialVersionUID = -16358134496498970L;
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
    }

    public ServiceResult error(String msg, Object object) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg(msg);
        serviceResult.setResultCode("999999");
        serviceResult.setResultObj(object);
        return serviceResult;
    }
    public ServiceResult success() {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg("success");
        serviceResult.setResultCode("000000");
        serviceResult.setResultObj("");
        return serviceResult;
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
