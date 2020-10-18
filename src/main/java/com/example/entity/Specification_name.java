package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
public class Specification_name {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "name_spec_name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category")
    @JsonIgnore
    private Category id_category;

    @OneToMany(mappedBy = "id_spec_name")
    @JsonIgnore
    private List<Specification_value> specification_values;


    public Specification_name() {
    }

    public Specification_name(Long id, String name, Category id_category, List<Specification_value> specification_values) {
        this.id = id;
        this.name = name;
        this.id_category = id_category;
        this.specification_values = specification_values;
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

    public Category getId_category() {
        return id_category;
    }

    public void setId_category(Category id_category) {
        this.id_category = id_category;
    }

    public List<Specification_value> getSpecification_values() {
        return specification_values;
    }

    public void setSpecification_values(List<Specification_value> specification_values) {
        this.specification_values = specification_values;
    }
}
