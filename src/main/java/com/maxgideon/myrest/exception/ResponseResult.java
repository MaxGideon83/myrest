package com.maxgideon.myrest.exception;

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
