package com.example.form;

import com.example.entity.Category;
import com.example.entity.SpecificationValue;

import java.util.List;

public class FormProduct {

    private String name;

    private float price;

    private String description;

    Category productCategory;

    List<SpecificationValue> specifications;

    public FormProduct() {
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

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public List<SpecificationValue> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<SpecificationValue> specifications) {
        this.specifications = specifications;
    }

}
