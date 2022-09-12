package com.back.jtmi.repository;

import com.back.jtmi.entity.BigCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BigCategoryRepository extends JpaRepository<BigCategory,Long> {

    Optional<BigCategory> findByBigId(Long id);
}
