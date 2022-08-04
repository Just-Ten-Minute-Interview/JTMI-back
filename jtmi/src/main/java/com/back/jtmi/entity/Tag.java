package com.back.jtmi.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor

public class Tag {
    @Id
    private Long tagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardId")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "middleId")
    private MiddleCategory middleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "smallId")
    private SmallCategory smallId;

//
//    @OneToMany(mappedBy = "middleId", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<MiddleCategory> middleCategory = new ArrayList<>();
//
//
//    @OneToMany(mappedBy = "smallId", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<SmallCategory> smallCategory = new ArrayList<>();


}
