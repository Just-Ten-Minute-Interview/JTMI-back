package com.back.jtmi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardCategoryDTO {
    public Long bigCategoryId;
    public String bigCategoryName;
    public Long middleCategoryId;
    public String middleCategoryName;
    public Long smallCategoryId;
    public String smallCategoryName;
}
