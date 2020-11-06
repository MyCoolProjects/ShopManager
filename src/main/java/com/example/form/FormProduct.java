package com.example.form;

import com.example.entity.Category;
import com.example.entity.Specification_value;

import java.util.List;

public class FormProduct {

    private String name;

    private float price;

    private String description;

    Category product_category;

    List<Specification_value> specifications;

    public FormProduct() {
    }

    public FormProduct(String name, float price, String description, Category product_category, List<Specification_value> specifications) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.product_category = product_category;
        this.specifications = specifications;
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
