package com.maxgideon.myrest.aop;

import org.springframework.stereotype.Component;

@Component
public class DataObject {

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}