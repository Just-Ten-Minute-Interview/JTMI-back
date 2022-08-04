package com.back.jtmi.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor

public class MiddleCategory {
    @Id
    private Long middleId;
    private String middleName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="bigId")
    private BigCategory bigCategory;


    @OneToMany(mappedBy = "tagId",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Tag> tag = new ArrayList<>();

}
