package com.back.jtmi.service;

import com.back.jtmi.entity.BigCategory;
import com.back.jtmi.entity.SmallCategory;
import com.back.jtmi.repository.BigCategoryRepository;
import com.back.jtmi.repository.MiddleCategoryRepository;
import com.back.jtmi.repository.SmallCategoryRepository;
import com.back.jtmi.response.error.CustomException;
import com.back.jtmi.response.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final BigCategoryRepository bigCategoryRepository;
    private final MiddleCategoryRepository middleCategoryRepository;
    private final SmallCategoryRepository smallCategoryRepository;


    @Transactional
    public SmallCategory validateSmallCategory(Long id){
        // TODO () -> lambda 식이 뭔지
        SmallCategory result =smallCategoryRepository.findBySmallId(id).orElseThrow(()-> new CustomException(ErrorCode.SMALL_CATEGORY_NOT_EXIST));
        return result;
    }


}
