package com.example.entity;

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

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "Id_Product")
    @JsonIgnore
    Product id_image_product;

    @OneToOne
    @JoinColumn(name = "id_image_news")
    @JsonIgnore
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
