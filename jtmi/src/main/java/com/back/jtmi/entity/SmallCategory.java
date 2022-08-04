package com.back.jtmi.entity;

import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor

public class SmallCategory {
    @Id
    private Long smallId;
    @OneToMany(mappedBy = "tagId",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Tag> tag = new ArrayList<>();


}
