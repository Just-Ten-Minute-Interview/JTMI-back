package com.back.jtmi.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NormalResponseDTO {
    private String name;
    private int number;


    public NormalResponseDTO(){
        this.name = "김경동";
        this.number = 1;
    }

}
