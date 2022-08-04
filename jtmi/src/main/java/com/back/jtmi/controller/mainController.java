package com.back.jtmi.controller;

import com.back.jtmi.entity.BigCategory;
import com.back.jtmi.repository.BigCategoryRepository;
import com.back.jtmi.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class mainController {

    private final BoardRepository boardRepository;
    private final BigCategoryRepository bigCategoryRepository;

    @GetMapping(value = "/")
    public ResponseEntity<String> findByid() {

        return new ResponseEntity<String>("hello", HttpStatus.FORBIDDEN);
//        if
//        return new ResponseEntity<String>("hello", 404);
    }

    @PostMapping(value = "/big")
    public ResponseEntity<String> addBig(String name) {
        BigCategory bigCategory = new BigCategory(name);
        bigCategoryRepository.save(bigCategory);

//        bigCategoryRepository.findAll();

        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }
    @PostMapping(value = "/error")
    public ResponseEntity<String> errorPage() {
//        BigCategory bigCategory = new BigCategory(name);
//        bigCategoryRepository.save(bigCategory);

//        bigCategoryRepository.findAll();

        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }

}
