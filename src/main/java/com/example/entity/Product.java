package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_prod")
    private String name;

    private float price;

    private String description;

    @ManyToOne
    @JoinColumn(name = "id_category")
    Category product_category;

    @OneToMany(mappedBy = "id_spec_product", fetch = FetchType.EAGER)
    List<Specification_value> specifications;

    public Product() {

    }

    public Product(Long id, String name, float price, String description, Category product_category, List<Specification_value> specifications) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getProduct_category() {
        return product_category;
    }

    public void setProduct_category(Category product_category) {
        this.product_category = product_category;
    }

    public List<Specification_value> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specification_value> specifications) {
        this.specifications = specifications;
    }
}
