package com.response;

import java.time.LocalDateTime;

public class ServiceResult {

    private static final long serialVersionUID = -1952381222311672233L;
    private String resultCode = "000000";
    private String resultMsg = "";
    private Object resultObj = null;
    private boolean flag = false;//返回的信息是否展示，true 前端要展示resultMsg
    private String time = LocalDateTime.now().toString();

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
        return this.putFlag(flag).putCode("999999").putMsg(msg).putObject(object);
    }

    /**
     * @param msg
     * @return flag为true的
     */
    public ServiceResult error(String msg) {
        this.setFlag(true);
        this.setResultMsg(msg);
        return this.putFlag(true).putMsg(msg);
    }

    /**
     * @param msg
     * @return flag为true
     */
    public ServiceResult ok(String msg) {
        return this.putFlag(true).putMsg(msg);
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


    public static void main(String[] args) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.putCode("200").putFlag(true).putFlag(false);
        System.out.println(serviceResult);
        System.out.println();
        LocalDateTime now = LocalDateTime.now();
    }

    public static void setParams(String... str) {
        if (str.length > 3) {
            return;
        }

        for (int i = 0; i < str.length; i++) {

        }
        System.out.println(str);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ServiceResult{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", resultObj=" + resultObj +
                ", flag=" + flag +
                ", time=" + time +
                '}';
    }

    /***链式编程*****/
    public ServiceResult putCode(String code) {
        this.setResultCode(code);
        return this;
    }

    public ServiceResult putMsg(String msg) {
        this.setResultMsg(msg);
        return this;
    }

    public ServiceResult putObject(Object object) {
        this.setResultObj(object);
        return this;
    }

    public ServiceResult putFlag(Boolean flag) {
        this.setFlag(flag);
        return this;
    }
}
