package com.maxgideon.myrest.advice;

/**
 * Класс обертка для возвращения сообщения пользователю в случае успешного сохранения и обновления данных в БД
 */
public class ResponseResult {

    private String result;

    public ResponseResult() {
    }

    public ResponseResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
