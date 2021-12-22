package com.maxgideon.myrest.advice;

import org.springframework.stereotype.Component;

/**
 * Класс обертка для возвращаемых данных
 */

public class DataObject {

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
