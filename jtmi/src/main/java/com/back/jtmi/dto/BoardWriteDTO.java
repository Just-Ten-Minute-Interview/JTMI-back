package com.back.jtmi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardWriteDTO {
    private Long smallId;
    private String board_title;
    private String board_content;
    private String board_prev_content;
}
