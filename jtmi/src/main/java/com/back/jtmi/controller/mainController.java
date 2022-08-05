package com.back.jtmi.controller;

import com.back.jtmi.dto.NormalResponseDTO;
import com.back.jtmi.entity.BigCategory;
import com.back.jtmi.repository.BigCategoryRepository;
import com.back.jtmi.repository.BoardRepository;
import com.back.jtmi.response.error.CustomException;
import com.back.jtmi.response.error.ErrorCode;
import com.back.jtmi.response.error.ErrorResponse;
import com.back.jtmi.response.error.ExceptionHandlers;
import com.back.jtmi.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequiredArgsConstructor
public class mainController {

    private final BoardRepository boardRepository;
    private final BigCategoryRepository bigCategoryRepository;
    private final ResponseService responseService;

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


    @PostMapping(value = "/error")
    public ResponseEntity<ErrorResponse> errorPage() {
        return responseService.generateError(ErrorCode.NOT_CORRECT);
    }

}
