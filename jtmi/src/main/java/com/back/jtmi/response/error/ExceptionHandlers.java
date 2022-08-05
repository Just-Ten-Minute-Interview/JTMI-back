package com.back.jtmi.response.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler({CustomException.class})
    public ResponseEntity<ErrorResponse> handleException(CustomException ex){
        ErrorResponse data = new ErrorResponse(ex.getErrorCode().getCode(), ex.getErrorCode().getMessage());
        return new ResponseEntity(data, HttpStatus.BAD_REQUEST);
    }

}
