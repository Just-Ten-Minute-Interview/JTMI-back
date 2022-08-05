package com.back.jtmi.controller;

import com.back.jtmi.entity.BigCategory;
import com.back.jtmi.entity.MiddleCategory;
import com.back.jtmi.entity.SmallCategory;
import com.back.jtmi.repository.BigCategoryRepository;
import com.back.jtmi.repository.MiddleCategoryRepository;
import com.back.jtmi.repository.SmallCategoryRepository;
import com.back.jtmi.response.error.CustomException;
import com.back.jtmi.response.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final BigCategoryRepository bigCategoryRepository;
    private final MiddleCategoryRepository middleCategoryRepository;
    private final SmallCategoryRepository smallCategoryRepository;

    @PostMapping(value = "/big")
    public ResponseEntity<String> addBig(String name) {
        BigCategory bigCategory = new BigCategory(name);
        bigCategoryRepository.save(bigCategory);

        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }
    @PostMapping(value = "/middle")
    public ResponseEntity<String> addMiddle(Long bigId,String name) {
        Optional<BigCategory> bigCategory = bigCategoryRepository.findByBigId(bigId);
        if (bigCategory.isEmpty()){
            throw new CustomException(ErrorCode.BIG_CATEGORY_NOT_EXIST);
        }
        MiddleCategory middle  = new MiddleCategory(name,bigCategory.get());
        middleCategoryRepository.save(middle);

        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }


    @PostMapping(value = "/small")
    public ResponseEntity<String> addSmall(Long middleId,String name) {
        Optional<MiddleCategory> middleCategory = middleCategoryRepository.findByMiddleId(middleId);
        if (middleCategory.isEmpty()){
            throw new CustomException(ErrorCode.MIDDLE_CATEGORY_NOT_EXIST);
        }
        SmallCategory smallCategory = new SmallCategory(name,middleCategory.get());
        smallCategoryRepository.save(smallCategory);

        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }

//    @PostMapping(value = "/tag")
//    public ResponseEntity<String> addSmall(String name) {
//        SmallCategory smallCategory = new SmallCategory(name);
//        smallCategoryRepository.save(smallCategory);
//
//        return new ResponseEntity<String>("hello", HttpStatus.OK);
//    }
}
