package com.back.jtmi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class MiddleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long middleId;

    private String middleName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="bigId")
    private BigCategory bigCategory;

    @OneToMany(mappedBy = "smallId",cascade = CascadeType.ALL,orphanRemoval = true)
    List<SmallCategory> smallCategory= new ArrayList<>();

    public MiddleCategory(String middleName,BigCategory bigCategory){
        this.middleName=middleName;
        this.bigCategory=bigCategory;
    }

}
