package com.back.jtmi.repository;

import com.back.jtmi.entity.BigCategory;
import com.back.jtmi.entity.MiddleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiddleCategoryRepository extends JpaRepository<MiddleCategory,Long> {
}
