package com.example.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Image")
    private Long id;

    @JsonIgnore
    private String type;
    @JsonIgnore
    private byte[] data;

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "Id_Product")
    @JsonIgnore
    Product id_image_product;

    public Image() {
    }

    public Image(Long id, String type, byte[] data, Product id_image_product) {
        this.id = id;
        this.type = type;
        this.data = data;
        this.id_image_product = id_image_product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Product getId_image_product() {
        return id_image_product;
    }

    @JsonAnyGetter
    public void setId_image_product(Product id_image_product) {
        this.id_image_product = id_image_product;
    }
}
