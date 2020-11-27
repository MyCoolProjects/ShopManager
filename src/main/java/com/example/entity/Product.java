package com.example.entity;

import com.example.form.FormProduct;
import com.example.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Products")
@JsonPropertyOrder({ "id" })
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    @JsonView({ JsonViews.ProductBasic.class, JsonViews.ImageBasic.class })
    @JsonProperty("id_product")
    private Long id;

    @Column(name = "name_product")
    @JsonView({ JsonViews.ProductBasic.class })
    @NotBlank
    private String name;

    @JsonView({ JsonViews.ProductBasic.class })
    @NotNull
    private float price;

    @JsonView({ JsonViews.ProductBasic.class })
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonView({ JsonViews.ProductBasic.class })
    Category productCategory;

    @OneToMany(mappedBy = "idSpecProduct", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonView({ JsonViews.ProductBasic.class })
    List<SpecificationValue> specifications;

    @OneToMany(mappedBy = "idImageProduct", cascade = CascadeType.REMOVE)
    @JsonView({ JsonViews.ProductBasic.class })
    List<Image> images;

    public Product() {

    }

    public Product(String name, float price, String description, Category productCategory) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.productCategory = productCategory;
    }

    public Product(FormProduct formProduct) {
        this.name = formProduct.getName();
        this.price = formProduct.getPrice();
        this.description = formProduct.getDescription();
        this.specifications = formProduct.getSpecifications();
        this.productCategory = formProduct.getProductCategory();
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
