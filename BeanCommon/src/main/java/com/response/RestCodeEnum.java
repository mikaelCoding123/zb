package com.response;

/**
 * 接口返回枚举定义
 */
public enum RestCodeEnum {
    /***成功**/
    SUCCESS("0000", "成功"),
    /*****参数错误：1001-1999*************/
    PARAM_IS_INVALID("1001", "参数无效"),
    /***********用户错误：2001-2999******************************/
    USER_NOT_LOGGED_IN("2001", "用户未登录，请登录"),
    USER_LOGIN_ERROR("2002", "账号不存在或者密码错误"),
    USER_ACCOUNT_FORBIDDEN("2003", "账号已被禁用"),
    USER_NOT_EXIST("2004", "用户不存在"),
    USER_HAS_EXISTED("2005", "用户已存在");

    private String code;
    private String msg;

    RestCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
