package com.common;

import com.enumcode.CodeEnum;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 返回的类型为HashMap，可以新增多个键值对
 */
public class Result extends HashMap<String, Object> implements Serializable {
    public Result() {

    }

    public static Result setCodeEnum(CodeEnum u, Object o) {
        Result result = new Result();
        result.put("code", u.getCode());
        result.put("msg", u.getMsg());
        result.put("data", o);
        return result;
    }

    public static Result defaultSuccess() {
        return Result.setCodeEnum(CodeEnum.SUCCESS, null);
    }

    public static Result defaultError() {
        return Result.setCodeEnum(CodeEnum.ERROR, null);
    }

    public static Result successObject(Object o) {
        return Result.setCodeEnum(CodeEnum.SUCCESS, o);
    }

    public static Result error(CodeEnum u, Object o) {
        return Result.setCodeEnum(u, o);
    }

    public static Result defaultException(String msg) {
        return Result.setCodeEnum(CodeEnum.Exception, null);
    }

    /**
     * 新增一个 Key Value
     *
     * @param u     codeEnum
     * @param key   Key
     * @param value object
     * @return result
     */
    public static Result addKV(CodeEnum u, String key, Object value) {
        Result result = Result.setCodeEnum(u, null);
        result.put(key, value);
        return result;
    }

}
