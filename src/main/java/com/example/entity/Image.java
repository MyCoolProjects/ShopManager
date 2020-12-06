package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Entity
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @NotNull
    private byte[] data;

    @JsonInclude(Include.NON_NULL)
    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    Product product;

    @JsonInclude(Include.NON_NULL)
    @OneToOne(mappedBy = "image", optional = true, fetch = FetchType.LAZY)
    NewsPost newsPost;

    public Image() {
    }

    public Image(String type, byte[] data, Product idImageProduct) {
        this.type = type;
        this.data = data;
        this.product = idImageProduct;
    }

}
