package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Specification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String value;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_specification_name")
    private Category category;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Product product;

}
