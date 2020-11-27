package com.example.entity;

import com.example.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Image")
    @JsonView({JsonViews.ImageBasic.class, JsonViews.ProductBasic.class})
    @JsonProperty("id_image")
    private Long id;

    @JsonIgnore
    private String type;

    @JsonIgnore
    @NotNull
    private byte[] data;

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "Id_Product")
    @JsonView({JsonViews.ImageBasic.class})
    @JsonUnwrapped
    Product id_image_product;

    @OneToOne
    @JoinColumn(name = "id_image_news")
    @JsonView({JsonViews.ImageBasic.class})
    @JsonUnwrapped
    News id_image_news;

    public Image() {
    }

    public Image(String type, byte[] data, Product id_image_product) {
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

    public void setId_image_product(Product id_image_product) {
        this.id_image_product = id_image_product;
    }

    public News getId_image_news() {
        return id_image_news;
    }

    public void setId_image_news(News id_image_news) {
        this.id_image_news = id_image_news;
    }
}
