package com.maxgideon.myrest.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;



@RestControllerAdvice
public class ExceptionAndResponseAdvice extends ResponseEntityExceptionHandler implements ResponseBodyAdvice<Object> {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseError> handleConstraintViolationException(ConstraintViolationException cve) {
        StringBuilder responseStr = new StringBuilder();
        String[] spl = cve.getMessage().split(",");
        for(int i = 0; i < spl.length; i++){
                String[] part = spl[i].split("\\.");
                responseStr.append(part[part.length-1]);
                responseStr.append(", ");
        }
        responseStr.setLength(responseStr.length()-2);
        ResponseError responseError = new ResponseError(responseStr.toString());
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<ResponseError> handleNoResultException(NoResultException nre){
        ResponseError responseError = new ResponseError(nre.getMessage());
        return new ResponseEntity<>(responseError,HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseError responseError = new ResponseError("Не правильный JSON");
        return new ResponseEntity<>(responseError, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseError responseError = new ResponseError(ex.getMessage());
        return new ResponseEntity<>(responseError,status);
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof ResponseError || body instanceof ResponseResult){
            return body;
        }
        if(body == null){
            return new ResponseResult("success");
        }
        DataObject dataObject = new DataObject();
        dataObject.setData(body);
        return dataObject;
    }
}
