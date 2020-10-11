package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "specificationsdb")
public class Specifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_spec")
    private String name;

    private String value;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "specifications_category")
    @JsonIgnore
    Category specifications_category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specifications_product")
    @JsonIgnore
    Product specifications_product;

    public Specifications() {
    }

    public Specifications(Long id, String name, String value, Category specifications_category,
            Product specifications_product) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.specifications_category = specifications_category;
        this.specifications_product = specifications_product;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public Category getSpecifications_category() {
        return specifications_category;
    }

    public Product getSpecifications_product() {
        return specifications_product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setSpecifications_category(Category specifications_category) {
        this.specifications_category = specifications_category;
    }

    public void setSpecifications_product(Product specifications_product) {
        this.specifications_product = specifications_product;
    }
}
