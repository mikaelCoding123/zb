package com.response;

import java.io.Serializable;

/**
 * 描述：     通用返回对象
 */
public class ApiRestResponse<T> implements Serializable {
    private final static long serialVersionUID = 1L;
    private String status;

    private String msg;

    private T data;

    private static final String OK_CODE = RestCodeEnum.SUCCESS.getCode();//默认的返回状态码

    private static final String OK_MSG = RestCodeEnum.SUCCESS.getMsg();//默认的返回状态信息

    public ApiRestResponse(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ApiRestResponse(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ApiRestResponse() {
        this(OK_CODE, OK_MSG);
    }//默认返回的构造方法

    //static <T>表示该方法为一个静态的泛型方法
    public static <T> ApiRestResponse<T> success() {
        return new ApiRestResponse<>();
    }//一个默认返回成功的方法，并调用默认的构造方法

    public static <T> ApiRestResponse<T> success(T result) {//重载的方法，带参数。请求成功时有时也需要带上一个返回值data
        ApiRestResponse<T> response = new ApiRestResponse<>();
        response.setData(result);//这样不仅携带了上面的OK_CODE, OK_MSG也携带了返回值data
        return response;
    }

    public static <T> ApiRestResponse<T> error(String code, String msg) {
        return new ApiRestResponse<>(code, msg);
    }

    public static <T> ApiRestResponse<T> error(RestCodeEnum ex) {//所有的错误都收拢在一起，这样遇到的话直接调用 利用异常枚举类即可
        return new ApiRestResponse<>(ex.getCode(), ex.getMsg());
    }

    @Override
    public String toString() {
        return "ApiRestResponse{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static String getOkCode() {
        return OK_CODE;
    }

    public static String getOkMsg() {
        return OK_MSG;
    }
}
 