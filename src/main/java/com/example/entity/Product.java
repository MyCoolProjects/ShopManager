package com.example.entity;

import com.example.form.FormProduct;
import com.example.view.Views;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "Products")
@JsonPropertyOrder({ "id" })
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Product")
    @JsonView({Views.FormProduct.class})
    @JsonProperty("id_product")
    private Long id;

    @Column(name = "name_product")
    @JsonView({Views.FormProduct.class})
    private String name;

    @JsonView({Views.FormProduct.class})
    private float price;

    @JsonView({Views.FormProduct.class})
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Id_Category")
    @JsonView({Views.FormProduct.class})
    Category product_category;

    @OneToMany(mappedBy = "id_spec_product", fetch = FetchType.EAGER)
    @JsonView({Views.FormProduct.class})
    List<Specification_value> specifications;

    @OneToMany(mappedBy = "id_image_product")
    @JsonView({Views.FormProduct.class})
    List<Image> images;

    public Product() {

    }

    public Product(String name, float price, String description, Category product_category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.product_category = product_category;
    }

    public Product(FormProduct formProduct) {
        this.name = formProduct.getName();
        this.price = formProduct.getPrice();
        this.description = formProduct.getDescription();
        this.specifications = formProduct.getSpecifications();
        this.product_category = formProduct.getProduct_category();
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
