package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private float price;

    private String description;

    @ManyToOne
    @JoinColumn(name = "product_category")
    Category product_category;

    @OneToMany(mappedBy="specifications_product",  fetch = FetchType.EAGER)
    List<Specifications> specifications;

    public Product() {

    }

    public Product(Long id, String name, float price, String description, Category product_category, List<Specifications> specifications) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.product_category = product_category;
        this.specifications = specifications;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Category getProduct_category() {
        return product_category;
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

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProduct_category(Category product_category) {
        this.product_category = product_category;
    }

    public void setSpecifications(List<Specifications> specifications) {
        this.specifications = specifications;
    }
}
