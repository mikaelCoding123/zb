package com.common;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 4971600066789355123L;

    public ServiceException(String s) {
        super(s);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}


