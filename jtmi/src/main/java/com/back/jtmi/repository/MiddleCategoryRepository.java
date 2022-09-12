package com.back.jtmi.repository;

import com.back.jtmi.entity.BigCategory;
import com.back.jtmi.entity.Board;
import com.back.jtmi.entity.MiddleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MiddleCategoryRepository extends JpaRepository<MiddleCategory,Long> {
    Optional<MiddleCategory> findByMiddleId(Long id);
//    Optional<Board> findBy
}
