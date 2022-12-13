package com.common;


import java.io.Serializable;

/**
 * @author mikael
 * @date 2020-12-13
 * @Description: 返回数据统一格式
 */
public class ServiceResult implements Serializable {

    private static final long serialVersionUID = -1785390400287984857L;
    private String code = CodeEnum.SUCCESS.getCode();
    private String msg = CodeEnum.SUCCESS.getMsg();
    private Object data = null;
    /**
     * 返回的信息是否展示，true 前端要展示msg中的内容
     */
    private boolean flag = false;

    public ServiceResult() {
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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "ServiceResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", flag=" + flag +
                '}';
    }

    /*******************************************************/

    /**
     * code = u.getCode();
     * msg = u.getMsg();
     * data = data;
     *
     * @param u
     * @param data
     */
    public static ServiceResult setEnum(CodeEnum u, Object data) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.code = u.getCode();
        serviceResult.msg = u.getMsg();
        serviceResult.data = data;
        return serviceResult;
    }

    /**
     * code = CodeEnum.SUCCESS.getCode();
     * msg = CodeEnum.SUCCESS.getMsg();
     * data = data;
     *
     * @param data
     */
    public static ServiceResult success(Object data) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.code = CodeEnum.SUCCESS.getCode();
        serviceResult.msg = CodeEnum.SUCCESS.getMsg();
        serviceResult.data = data;
        return serviceResult;
    }

    /**
     * serviceResult.code = u.getCode();
     * serviceResult.msg = u.getMsg();
     * serviceResult.data = data;
     *
     * @param u
     * @param data
     * @return serviceResult
     */
    public static Object success(CodeEnum u, Object data) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.code = u.getCode();
        serviceResult.msg = u.getMsg();
        serviceResult.data = data;
        return serviceResult;
    }

    /**
     * code = u.getCode();
     * msg = u.getMsg();
     *
     * @param u
     */
    public static ServiceResult error(CodeEnum u) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.code = u.getCode();
        serviceResult.msg = u.getMsg();
        return serviceResult;
    }

    /**
     * code = u.getCode();
     * msg = e.getMessage();
     *
     * @param u
     * @param e
     */
    public static ServiceResult setException(CodeEnum u, Exception e) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.code = u.getCode();
        serviceResult.msg = e.getMessage();
        return serviceResult;
    }

    /**
     * serviceResult.code = CodeEnum.ERROR.getCode();
     * serviceResult.msg = msgEnum.getMsg_1() + msg + msgEnum.getMsg_2();
     * serviceResult.flag=true;
     *
     * @param msgEnum
     * @param msg
     * @return
     */
    public static ServiceResult setErrorMsg(MsgEnum msgEnum, String msg) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.code = CodeEnum.ERROR.getCode();
        serviceResult.msg = msgEnum.getMsg_1() + msg + msgEnum.getMsg_2();
        serviceResult.flag = true;
        return serviceResult;
    }

    /**
     * serviceResult.code = CodeEnum.ERROR.getCode();
     * serviceResult.msg = msg;
     * serviceResult.flag=true;
     * 尽量不要用，用多了代码容易混乱
     *
     * @param msg
     * @return
     */
    @Deprecated
    public static ServiceResult setErrorMsg(String msg) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.code = CodeEnum.ERROR.getCode();
        serviceResult.msg = msg;
        serviceResult.flag = true;
        return serviceResult;
    }


    public static void main(String[] args) {
        ServiceResult result = new ServiceResult();
        ServiceResult sfsd = ServiceResult.success("sfsd");
        System.out.println(ServiceResult.success("sfsd"));
    }
}
