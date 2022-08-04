package com.back.jtmi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class BigCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bigId;
    @Column
    private String bigName;

    public BigCategory(String name){
        this.bigName = name;
    }
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    List<MiddleCategory> middleCategory= new ArrayList<>();


}
