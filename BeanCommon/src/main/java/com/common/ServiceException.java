package com.common;

import java.io.Serializable;

public class ServiceException extends RuntimeException implements Serializable {

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


