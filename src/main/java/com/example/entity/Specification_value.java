package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import javax.persistence.*;

@Entity
public class Specification_value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_spec_name")
    @JsonUnwrapped
    private Specification_name id_spec_name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_spec_product")
    @JsonIgnore
    private Product id_spec_product;

    public Specification_value() {
    }

    public Specification_value(Long id, String value, Specification_name id_spec_name, Product id_spec_product) {
        this.id = id;
        this.value = value;
        this.id_spec_name = id_spec_name;
        this.id_spec_product = id_spec_product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Specification_name getId_spec_name() {
        return id_spec_name;
    }

    public void setId_spec_name(Specification_name id_spec_name) {
        this.id_spec_name = id_spec_name;
    }

    public Product getId_spec_product() {
        return id_spec_product;
    }

    public void setId_spec_product(Product id_spec_product) {
        this.id_spec_product = id_spec_product;
    }
}
