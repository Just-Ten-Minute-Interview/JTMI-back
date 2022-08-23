package com.back.jtmi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class SmallCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long smallId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="middleId")
    private MiddleCategory middleCategory;

    private String smallName;
    @OneToMany(mappedBy = "tagId",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Tag> tag = new ArrayList<>();

    public SmallCategory(String smallName,MiddleCategory middleCategory){
        this.smallName = smallName;
        this.middleCategory= middleCategory;

    }

}
