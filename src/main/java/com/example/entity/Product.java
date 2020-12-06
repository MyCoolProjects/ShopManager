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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({ "id" })
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
    @JoinColumn
    @JsonIgnoreProperties("products")
    Category category;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinTable
    @JsonIgnoreProperties("products")
    List<Specification> specifications;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    List<Image> images;

}
