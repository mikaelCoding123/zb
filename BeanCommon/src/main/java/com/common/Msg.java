package com.common;

public class Msg extends CommonMsg{

    public final String Error="失败！";

    public static void main(String[] args) {
        Msg msg = new Msg();
        System.out.println(msg.SUCCESS);
    }

}

