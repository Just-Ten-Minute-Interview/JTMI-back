package com.back.jtmi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BoardDetailDTO {
    private Long boardId;
    private String boardTitle;
    private String boardPrevContent;
    private String boardContent;
    private List<BoardCategoryDTO> boardCategoryDTO;



}
