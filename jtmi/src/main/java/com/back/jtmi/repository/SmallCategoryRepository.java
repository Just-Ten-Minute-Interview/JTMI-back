package com.back.jtmi.repository;

import com.back.jtmi.entity.BigCategory;
import com.back.jtmi.entity.SmallCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmallCategoryRepository extends JpaRepository<SmallCategory,Long> {
}
