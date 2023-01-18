package com.common;

import java.io.Serializable;

public class ServiceException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -1L;

    /**
     * msgenum
     *
     * @param msg msgenum
     */
    public ServiceException(String msg) {
        super(msg);
    }

    public static void main(String[] args) {
        new ServiceException("yihchsjfk").printStackTrace();
        System.out.println(
                new ServiceException("你好").getMessage());
    }
}


