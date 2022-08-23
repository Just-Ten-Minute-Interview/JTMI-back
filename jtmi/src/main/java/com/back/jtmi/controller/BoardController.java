package com.back.jtmi.controller;

import com.back.jtmi.dto.BoardDetailDTO;
import com.back.jtmi.dto.BoardWriteDTO;
import com.back.jtmi.dto.NormalResponseDTO;
import com.back.jtmi.entity.SmallCategory;
import com.back.jtmi.response.error.CustomException;
import com.back.jtmi.response.error.ErrorCode;
import com.back.jtmi.service.BoardService;
import com.back.jtmi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final CategoryService categoryService;
    private final BoardService boardService;

    @GetMapping(value = "/board/")
    public ResponseEntity<?> findByid() {
        NormalResponseDTO normal = new NormalResponseDTO();
        Random rand = new Random();
        int i = rand.nextInt(10);
        if (i < 5) {
            throw new CustomException(ErrorCode.NOT_CORRECT);
        }

        return new ResponseEntity<NormalResponseDTO>(normal, HttpStatus.OK);
    }
    @GetMapping(value = "/board")
    public ResponseEntity<?> findCategory(@PathVariable(required = false ,value="big")String big,
                                      @PathVariable(required = false ,value="middle")String middle,
                                      @PathVariable(required = false ,value="small")String small) {

        return new ResponseEntity<>("hi", HttpStatus.OK);
    }
    @GetMapping(value = "/board/{id}")
    public ResponseEntity<?> showBoard(@PathVariable("id") Long id) {
        BoardDetailDTO boardDetailDTO =boardService.showBoard(id);

        return new ResponseEntity<>(boardDetailDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/board")
    public ResponseEntity<?> writeBoard(@RequestBody BoardWriteDTO boardWriteDTO) {
        SmallCategory smallCategory = categoryService.validateSmallCategory(boardWriteDTO.getSmallId());
        boardService.writeBoard(boardWriteDTO,smallCategory);
        return new ResponseEntity<String>("hi", HttpStatus.OK);
    }

}
