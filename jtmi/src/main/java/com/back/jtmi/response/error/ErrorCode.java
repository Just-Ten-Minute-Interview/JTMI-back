package com.back.jtmi.response.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_CORRECT(1022,"hi","(랜덤으로 발생한 에러)이렇게 에러가 발생합니다"),
    BIG_CATEGORY_NOT_EXIST(1001,"Big_Category_NOT_EXIST","대분류가 존재하지 않습니다."),
    MIDDLE_CATEGORY_NOT_EXIST(1022,"Middle_Category_NOT_EXIST","중분류가 존재하지 않습니다."),
    SMALL_CATEGORY_NOT_EXIST(1022,"Small_Category_NOT_EXIST","소분류가 존재하지 않습니다."),
    BOARD_NOT_EXIST(1023,"Board_NOT_EXIST","게시글이 존재하지않습니다.");


    private int code;
    private String title;
    private String message;

}
