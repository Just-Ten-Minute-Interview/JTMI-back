package com.back.jtmi.response;

import lombok.Getter;

@Getter
public enum ErrorCode {
    NOT_CORRECT(1001,"hi","error")
    ;
    private int code;
    private String title;
    private String message;

    ErrorCode(int code, String title, String message) {
        this.code = code;
        this.title = title;
        this.message= message;
    }
}
