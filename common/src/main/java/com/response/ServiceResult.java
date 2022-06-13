package com.response;

import java.io.Serializable;

public class ServiceResult implements Serializable {
    private static final long serialVersionUID = 1635241255686L;
    private String resultCode = "000000";
    private String resultMsg = "success";
    private Object resultObj = null;
    private boolean flag = false;//返回的信息是否展示，true 前端要展示resultMsg

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    public ServiceResult() {
    }

    public ServiceResult(String message) {
        this.resultMsg = message;
    }

    public ServiceResult(String code, String message) {
        this.resultCode = code;
        this.resultMsg = message;
    }

    public ServiceResult(String code, String message, Object object) {
    }

    public ServiceResult error(String msg, Object object, boolean flag) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg(msg);
        serviceResult.setResultCode("999999");
        serviceResult.setResultObj(object);
        serviceResult.setFlag(flag);
        return serviceResult;
    }

    /**
     * @param msg
     * @return flag为true的
     */
    public ServiceResult error(String msg) {
        this.setFlag(true);
        this.setResultMsg(msg);
        return this;
    }

    /**
     * @param msg
     * @return flag为true
     */
    public ServiceResult ok(String msg) {
        this.setFlag(true);
        this.setResultMsg(msg);
        return this;
    }


    public ServiceResult ok() {
        return this;
    }

    public ServiceResult(Object object) {
        this.resultObj = object;
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

    @Override
    public String toString() {
        return "ServiceResult{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", resultObj=" + resultObj +
                ", flag=" + flag +
                '}';
    }

    public static void main(String[] args) {
        ServiceResult serviceResult = new ServiceResult("12", "咯活啊", "123213");
        System.out.println(serviceResult);
        ServiceResult serviceResult1 = new ServiceResult();
        setParams("123", "2313");
        serviceResult.ok("123");
        serviceResult1.error("2313");
        System.out.println(serviceResult1);
    }

    public static void setParams(String... str) {
        if (str.length > 3) {
            return;
        }

        for (int i = 0; i < str.length; i++) {

        }
        System.out.println(str);
    }
}
