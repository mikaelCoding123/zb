package com.response;


import java.io.Serializable;

/**
 * @author mikael
 * @date 2020-12-13
 * @Description: 返回数据统一格式
 */
public class Result implements Serializable {
    private static final long serialVersionUID = -8898003017479253967L;
    private String code = CodeEnum.SUCCESS.getCode();
    private String msg = CodeEnum.SUCCESS.getMsg();
    private Object data = null;
    /**
     * 返回的信息是否展示，true 前端要展示msg中的内容
     */
    private boolean flag = false;

    public Result() {
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
        return "Result{" +
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
    public void setEnum(CodeEnum u, Object data) {
        this.code = u.getCode();
        this.msg = u.getMsg();
        this.data = data;
    }

    /**
     * code = CodeEnum.SUCCESS.getCode();
     * msg = CodeEnum.SUCCESS.getMsg();
     * data = data;
     *
     * @param data
     */
    public void success(Object data) {
        this.code = CodeEnum.SUCCESS.getCode();
        this.msg = CodeEnum.SUCCESS.getMsg();
        this.data = data;
    }

    /**
     * code = u.getCode();
     * msg = u.getMsg();
     *
     * @param u
     */
    public void error(CodeEnum u) {
        this.code = u.getCode();
        this.msg = u.getMsg();
    }

    /**
     * code = u.getCode();
     * msg = e.getMessage();
     *
     * @param u
     * @param e
     */
    public void setException(CodeEnum u, Exception e) {
        this.code = u.getCode();
        this.msg = e.getMessage();
    }

    public static void main(String[] args) {
        Result result = new Result();
        result.setException(CodeEnum.ERROR, new Exception("异常21331"));
        System.out.println(result);
    }
}
