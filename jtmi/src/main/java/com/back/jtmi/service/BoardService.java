package com.back.jtmi.service;

import com.back.jtmi.dto.BoardCategoryDTO;
import com.back.jtmi.dto.BoardDetailDTO;
import com.back.jtmi.dto.BoardListResponse;
import com.back.jtmi.dto.BoardWriteDTO;
import com.back.jtmi.entity.*;
import com.back.jtmi.repository.BigCategoryRepository;
import com.back.jtmi.repository.BoardRepository;
import com.back.jtmi.repository.MiddleCategoryRepository;
import com.back.jtmi.repository.TagRepository;
import com.back.jtmi.response.error.CustomException;
import com.back.jtmi.response.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final TagRepository tagRepository;
    private final BigCategoryRepository bigCategoryRepository;
    private final MiddleCategoryRepository middleCategoryRepository;

    @Transactional
    public void writeBoard(BoardWriteDTO boardWriteDTO, SmallCategory smallCategory) {
        Board board = new Board(boardWriteDTO.getBoard_title(), boardWriteDTO.getBoard_prev_content(), boardWriteDTO.getBoard_content());
        boardRepository.save(board);
        addTag(board, smallCategory);

    }

    @Transactional
    public void addTag(Board board, SmallCategory smallCategory) {
        Tag tag = new Tag(board, smallCategory);
        tagRepository.save(tag);
    }

    public BoardDetailDTO showBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_EXIST));
        List<Tag> tag = board.getTag();
        List<BoardCategoryDTO> categoryList = new ArrayList<>();

        for (Tag t : tag) {
            SmallCategory small = t.getSmallCategory();
            MiddleCategory middle = small.getMiddleCategory();
            BigCategory big = middle.getBigCategory();
            BoardCategoryDTO boardCategoryDTO = new BoardCategoryDTO(board.getBoardId(), big.getBigName(), middle.getMiddleId(), middle.getMiddleName(), small.getSmallId(), small.getSmallName());
            categoryList.add(boardCategoryDTO);
        }
        BoardDetailDTO boardDetailDTO =new BoardDetailDTO(board.getBoardId(), board.getBoardTitle(), board.getBoardPrevContent(), board.getBoardContent(),categoryList);

        return boardDetailDTO;
    }

    public List<BoardDetailDTO> findByBigCategory(Long id) {
        BigCategory bigCategory = bigCategoryRepository.findByBigId(id).orElseThrow(()-> new CustomException(ErrorCode.BIG_CATEGORY_NOT_EXIST));
        List<BoardDetailDTO> boardDetailDTOList = new ArrayList<>();
        List<Board> boards =boardRepository.findBoardsByBigCategory(bigCategory);
        for (Board b: boards){
            BoardDetailDTO details =showBoard(id);
            boardDetailDTOList.add(details);

        }
        return boardDetailDTOList;
    }
    public List<BoardDetailDTO> findByMiddleCategory(Long id) {
        MiddleCategory middleCategory = middleCategoryRepository.findByMiddleId(id).orElseThrow(()-> new CustomException(ErrorCode.BIG_CATEGORY_NOT_EXIST));
        List<BoardDetailDTO> boardDetailDTOList = new ArrayList<>();
        List<Board> boards =boardRepository.findBoardsByMiddleCategory(middleCategory);
        for (Board b: boards){
            BoardDetailDTO details =showBoard(id);
            boardDetailDTOList.add(details);

        }
        return boardDetailDTOList;
    }
}
