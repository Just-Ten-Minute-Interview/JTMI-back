package com.back.jtmi.service;

import com.back.jtmi.response.error.ErrorCode;
import com.back.jtmi.response.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    public ResponseEntity<ErrorResponse> generateError(ErrorCode errorCode){
        ErrorResponse data = new ErrorResponse(errorCode.getCode(),errorCode.getMessage());
        return new ResponseEntity<ErrorResponse>(data, HttpStatus.BAD_REQUEST);
    }
}
