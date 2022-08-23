package com.back.jtmi.repository;

import com.back.jtmi.entity.BigCategory;
import com.back.jtmi.entity.SmallCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SmallCategoryRepository extends JpaRepository<SmallCategory,Long> {
    Optional<SmallCategory> findBySmallId(Long id);
}
