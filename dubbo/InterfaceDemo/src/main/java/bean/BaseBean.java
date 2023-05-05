package bean;

import java.io.Serializable;

public class BaseBean implements Serializable {
    private String method;
    private Object object;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
