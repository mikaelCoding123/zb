package com.enumcode;

/**
 * encoded: UTF-8
 * <p>
 * 魔法值  一些特定的固定值
 */
public enum MagicValueEnum {
    /**
     * 版本号
     */
    version(1, 1L, "23.01.06"),
    t1(1, 1L, "wf"),
    t2(3, 1L, "fwef"),

    ;
    /**
     * Integer类型
     */
    private Integer i;
    /**
     * Long类型
     */
    private Long l;
    /**
     * String类型
     */
    private String str;

    MagicValueEnum(int i, long l, String str) {
        this.i = i;
        this.l = l;
        this.str = str;
    }

    public int getInt() {
        return i;
    }

    public void setInt(int i) {
        this.i = i;
    }

    public long getLong() {
        return l;
    }

    public void setLong(long l) {
        this.l = l;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

}
