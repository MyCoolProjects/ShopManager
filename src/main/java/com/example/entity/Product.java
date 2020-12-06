package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonPropertyOrder({ "id" })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private float price;

    private String description;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    Category category;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinTable(joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "specification_id"))
    List<Specification> specifications;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinTable(joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "image_id"))
    List<Image> images;

}
