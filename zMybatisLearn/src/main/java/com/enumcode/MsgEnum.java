package com.enumcode;

/**
 * encoded: UTF-8
 * <p>
 * 消息进行拼接的时候用到
 */
public enum MsgEnum {
    /**
     *
     */
    msg01("你好", "先生\\女士", "", ""),
    SUCCESS("启动成功==》", "端口：", "", ""),
    exception("异常", "", "", ""),


    ;
    private String msg_1;
    private String msg_2;
    private String msg_3;
    private String msg_4;


    MsgEnum(String msg_1, String msg_2, String msg_3, String msg_4) {
        this.msg_1 = msg_1;
        this.msg_2 = msg_2;
        this.msg_3 = msg_3;
        this.msg_4 = msg_4;
    }

    public String getMsg_1() {
        return msg_1;
    }

    public void setMsg_1(String msg_1) {
        this.msg_1 = msg_1;
    }

    public String getMsg_2() {
        return msg_2;
    }

    public void setMsg_2(String msg_2) {
        this.msg_2 = msg_2;
    }

    public String getMsg_3() {
        return msg_3;
    }

    public void setMsg_3(String msg_3) {
        this.msg_3 = msg_3;
    }

    public String getMsg_4() {
        return msg_4;
    }

    public void setMsg_4(String msg_4) {
        this.msg_4 = msg_4;
    }
}
