package com.back.jtmi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String boardTitle;
    private String boardPrevContent;
    private String boardContent;

    @OneToMany(mappedBy = "tagId",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Tag> tag = new ArrayList<>();
    public Board(String boardTitle, String boardPrevContent,String boardContent){
        this.boardTitle=boardTitle;
        this.boardPrevContent=boardPrevContent;
        this.boardContent=boardContent;

    }
}
