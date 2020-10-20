package com.example.form;

import com.example.entity.Category;
import com.example.entity.Specification_value;

import java.util.List;

public class FormProduct {

    private Long id;

    private String name;

    private float price;

    private String description;

    private String image;

    Category product_category;

    List<Specification_value> specifications;

    public FormProduct() {
    }

    public FormProduct(Long id, String name, String image, float price, String description, Category product_category, List<Specification_value> specifications) {
        this.id = id;
        this.name = name;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
