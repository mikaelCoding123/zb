package com.mk.common.result;


import java.io.Serializable;
import java.util.HashMap;

/**
 * 返回的类型为HashMap，可以新增多个键值对
 */
public class Result extends HashMap<String, Object> implements Serializable {

    public Result() {
        put("code", "000000");
        put("msg", "操作成功");
    }

    public static Result error() {
        return error("999999", "操作失败");
    }

    public static Result error(String msg) {
        return error("999999", msg);
    }

    public static Result error(String code, String msg) {
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

    public static Result putKV(String k, Object o) {
        Result r = new Result();
        r.put(k, o);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    public static Result ok(Object o) {
        Result r = new Result();
        r.put("data", o);
        return r;
    }


    public Result putData(Object value) {
        super.put("data", value);
        return this;
    }
}
