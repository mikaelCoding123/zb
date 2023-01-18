package com.enumcode;

/**
 * encoded: UTF-8
 * <p>
 * 魔法值  一些特定的固定值(数字，字符串)
 */
public enum MagicValueEnum {
    /**
     * (versin)x.y.z[state]
     * <p>
     * x、y  递增
     * z 为年月
     * state a\b\RC1\GA 四种情况 其中RC1表示RC版的第一个版本
     * <p>
     * 版本号
     */
    version(1, 2301L, "1.0.2301RC1"),
    M001(1, 1L, "https://www.baidu.com/"),
    M002(3, 1L, "fwef"),

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
