package com.back.jtmi.repository;

import com.back.jtmi.entity.BigCategory;
import com.back.jtmi.entity.Board;
import com.back.jtmi.entity.MiddleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    @Query("select b from Board b join b.tag t join t.smallCategory s join s.middleCategory m where m.bigCategory=:bigCategory ")
    List<Board> findBoardsByBigCategory(@Param("bigCategory")BigCategory bigCategory);
    @Query("select b from Board b join b.tag t join t.smallCategory s where s.middleCategory=:middleCategory ")
    List<Board> findBoardsByMiddleCategory(@Param("middleCategory") MiddleCategory middleCategory);
}
