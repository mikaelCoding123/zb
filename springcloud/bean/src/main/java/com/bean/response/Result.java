package com.bean.response;



import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Description:  返回数据统一化
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 1879L;

    public Result() {
        put("code", HttpStatus.SC_OK);
        put("msg", "success");
    }

    /**
     * @Description: 返回 msg="未知异常，请联系管理员"
     */
    public static Result error() {
        return error(HttpStates.Server_Error_Msg, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(HttpStates.Server_Error_Msg, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Map<String,?> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public Result putResult(Object value) {
        super.put("result", value);
        return this;
    }
    public Object getResult(){
        return super.get("result");
    }
}
