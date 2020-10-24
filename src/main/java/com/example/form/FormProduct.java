package com.example.form;

import com.example.entity.Category;
import com.example.entity.Image;
import com.example.entity.Specification_value;

import java.util.List;

public class FormProduct {

    private Long id;

    private String name;

    private float price;

    private String description;

    Category product_category;

    List<Specification_value> specifications;

    List<Image> images;

    public FormProduct() {
    }

    public FormProduct(Long id, String name, float price, String description, Category product_category, List<Specification_value> specifications, List<Image> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.product_category = product_category;
        this.specifications = specifications;
        this.images = images;
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
