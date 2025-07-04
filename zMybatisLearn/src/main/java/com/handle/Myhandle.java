package com.handle;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

public class Myhandle implements ResultHandler {
    @Override
    public void handleResult(ResultContext resultContext) {
        Object resultObject = resultContext.getResultObject();

    }
}
