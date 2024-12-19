package org.example.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalErrorException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handleGlobalException(AccountException ac, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(ac.getMessage() , LocalDateTime.now(), request.getDescription(false) , "account not found");
        return  new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ErrorDetail> genericExceptionHandler(AccountException ac, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(ac.getMessage() , LocalDateTime.now(), request.getDescription(false) , "account not found");
        return  new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

}
