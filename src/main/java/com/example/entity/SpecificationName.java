package com.example.entity;

import com.example.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "SpecificationNames")
public class SpecificationName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_specification_name")
    @JsonView({JsonViews.ProductBasic.class})
    private Long id;

    @Column(name = "name_specification_name")
    @JsonView({JsonViews.ProductBasic.class})
    @NotBlank
    private String name;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JsonIgnore
    private Category idCategory;

    @Column(name = "name_specification_value")
    @OneToMany(mappedBy = "idSpecName")
    @JsonIgnore
    private List<SpecificationValue> specificationValues;


    public SpecificationName() {
    }

    public SpecificationName(String name, Category idCategory) {
        this.name = name;
        this.idCategory = idCategory;
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

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public List<SpecificationValue> getSpecificationValues() {
        return specificationValues;
    }

    public void setSpecificationValues(List<SpecificationValue> specificationValues) {
        this.specificationValues = specificationValues;
    }
}
