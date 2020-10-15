package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_cat")
    private String name;

    @OneToMany(mappedBy = "product_category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    List<Product> product;

    @OneToMany(mappedBy = "specifications_category", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    List<Specifications> specifications;

    public Category() {
    }

    public Category(Long id, String name, List<Product> product, List<Specifications> specifications) {
        this.id = id;
        this.name = name;
        this.product = product;
        this.specifications = specifications;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public List<Specifications> getSpecifications() {
        return specifications;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public void setSpecifications(List<Specifications> specifications) {
        this.specifications = specifications;
    }
}
