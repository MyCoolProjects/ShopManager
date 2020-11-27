package com.example.entity;

import com.example.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "SpecificationValues")
public class SpecificationValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @JsonView({JsonViews.ProductBasic.class})
    @NotBlank
    private String value;

    @ManyToOne(/*optional = false, */cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_specification_name")
    @JsonUnwrapped
    @JsonView({JsonViews.ProductBasic.class})
    private SpecificationName idSpecName;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    private Product idSpecProduct;

    public SpecificationValue() {
    }

    public SpecificationValue(String value, SpecificationName idSpecName, Product idSpecProduct) {
        this.value = value;
        this.idSpecName = idSpecName;
        this.idSpecProduct = idSpecProduct;
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

    public SpecificationName getIdSpecName() {
        return idSpecName;
    }

    public void setIdSpecName(SpecificationName idSpecName) {
        this.idSpecName = idSpecName;
    }

    public Product getIdSpecProduct() {
        return idSpecProduct;
    }

    public void setIdSpecProduct(Product idSpecProduct) {
        this.idSpecProduct = idSpecProduct;
    }
}
