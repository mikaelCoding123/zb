package com.common;

import com.response.ServiceResult;

/**
 * 接口返回枚举定义
 * 只增加不删除
 * 错误的code定义规范：应用名简称或者应用代号+“-”+6位数字码
 */
public enum CodeEnum {
    /**
     * success
     */
    SUCCESS("000000", "成功", false),
    /**
     * 未知错误
     */
    ERROR("99998", "未知错误。。。。。", false),
    /**
     * 异常
     */
    Exception("999999", "异常", false),
    /*****参数错误：10001-19999***********************************************************/
    PARAM_IS_INVALID("10001", "参数无效", false),
    /***********用户错误：20001-29999****************************************************/
    USER_NOT_LOGGED_IN("20001", "用户未登录，请登录", false),
    USER_LOGIN_ERROR("20002", "账号不存在或者密码错误", false),
    USER_ACCOUNT_FORBIDDEN("20003", "账号已被禁用", false),
    USER_NOT_EXIST("20004", "用户不存在", false),
    USER_HAS_EXISTED("20005", "用户已存在", false),
    /*************第三方接口请求：30001-39999******************************************************/
    THIRD_TOKEN_GET_FAILED("30001", "token获取失败", false),
    THIRD_TOKEN_INVALID("30002", "token失效", false),
    /**********************:40001-49999*************************************************/

    /**********************:50001-59999*************************************************/

    /**********************99999*************************************************/
    ERROR_CONTACT_CUSTOMER_SERVICE("99999", "系统维护中。。。。。", false),
    RC91000("91000", "91000错误", false),

    ;


    private String code;
    private String msg;
    private boolean flag;

    CodeEnum(String code, String msg, boolean flag) {
        this.code = code;
        this.msg = msg;
        this.flag = flag;
    }


    public static void main(String[] args) {
        com.response.ServiceResult serviceResult = new ServiceResult();
        serviceResult.putMsg(CodeEnum.SUCCESS.msg);
        System.out.println(CodeEnum.SUCCESS.code);
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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
