package com.back.jtmi.response.error;

import com.back.jtmi.response.CommonResult;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse extends CommonResult {
    private int code;
    private String message;


    public ErrorResponse(int code, String message) {
        this.code=code;
        this.message= message;
    }
}
