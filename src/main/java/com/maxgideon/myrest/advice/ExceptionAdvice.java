package com.maxgideon.myrest.advice;


import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;



@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

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

}
