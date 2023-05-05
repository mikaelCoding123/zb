package com.common;

import com.enumcode.CodeEnum;

import java.io.Serializable;
import java.util.HashMap;

public class Result extends HashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = -1L;

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

    /**
     * 新增一个 K V
     *
     * @param u   codeEnum
     * @param key Key
     * @param o   object
     * @return result
     */
    public static Result addKV(CodeEnum u, String key, Object o) {
        Result result = Result.setCodeEnum(u, null);
        result.put(key, o);
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Result.defaultSuccess());
        System.out.println(Result.addKV(CodeEnum.Exception, "trid", "jsfhkjdhf"));


    }

}
