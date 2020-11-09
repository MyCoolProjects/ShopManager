package com.example.entity;

import com.example.view.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Specification_values")
public class Specification_value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Specification_value")
    @JsonIgnore
    private Long id;

    @JsonView({Views.ProductBasic.class})
    @NotBlank
    private String value;

    @ManyToOne(/*optional = false, */cascade = CascadeType.MERGE)
    @JoinColumn(name = "Id_Specification_name")
    @JsonUnwrapped
    @JsonView({Views.ProductBasic.class})
    private Specification_name id_spec_name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Id_Product")
    @JsonIgnore
    private Product id_spec_product;

    public Specification_value() {
    }

    public Specification_value(String value, Specification_name id_spec_name, Product id_spec_product) {
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
