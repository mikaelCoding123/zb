package com.exception;

import com.common.CodeEnum;

import java.io.Serializable;

public class ServiceException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -1L;
    /**
     * 错误状态码
     */
    protected String errorCode;
    /**
     * 错误提示
     */
    protected String errorMsg;

    public ServiceException() {
    }

    public ServiceException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static void main(String[] args) {
        new ServiceException(CodeEnum.Exception.getCode(),CodeEnum.Exception.getMsg()).getMessage();
        System.out.println();
    }
}


