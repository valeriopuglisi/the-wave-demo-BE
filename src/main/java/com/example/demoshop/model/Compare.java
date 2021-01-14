package com.example.demoshop.model;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
@Entity // This tells Hibernate to make a table out of this class
public class Compare {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_1")
    private Product prodOne;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_2")
    private Product prodTwo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_3")
    private Product prodThree;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProdOne() {
        return prodOne;
    }

    public void setProdOne(Product prodOne) {
        this.prodOne = prodOne;
    }

    public Product getProdTwo() {
        return prodTwo;
    }

    public void setProdTwo(Product prodTwo) {
        this.prodTwo = prodTwo;
    }

    public Product getProdThree() {
        return prodThree;
    }

    public void setProdThree(Product prodThree) {
        this.prodThree = prodThree;
    }
}
