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

    @OneToMany(mappedBy = "product_category")
    @JsonIgnore
    private List<Product> product;

    @OneToMany(mappedBy = "id_category")
    @JsonIgnore
    private List<Specification_name> specifications;

    public Category() {
    }

    public Category(Long id, String name, List<Product> product, List<Specification_name> specifications) {
        this.id = id;
        this.name = name;
        this.product = product;
        this.specifications = specifications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public List<Specification_name> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specification_name> specifications) {
        this.specifications = specifications;
    }
}
