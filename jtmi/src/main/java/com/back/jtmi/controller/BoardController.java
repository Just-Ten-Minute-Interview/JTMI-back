package com.back.jtmi.controller;

import com.back.jtmi.dto.NormalResponseDTO;
import com.back.jtmi.response.error.CustomException;
import com.back.jtmi.response.error.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController("/board")
public class BoardController {
    @GetMapping(value = "/")
    public ResponseEntity<?> findByid() {
        NormalResponseDTO normal = new NormalResponseDTO();
        Random rand = new Random();
        int i = rand.nextInt(10);
        if (i<5){
            throw new CustomException(ErrorCode.NOT_CORRECT);
        }

        return new ResponseEntity<NormalResponseDTO>(normal, HttpStatus.OK);
    }

}
