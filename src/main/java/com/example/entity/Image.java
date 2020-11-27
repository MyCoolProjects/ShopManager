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
    @Column(name = "id_image")
    @JsonView({ JsonViews.ImageBasic.class, JsonViews.ProductBasic.class })
    @JsonProperty("id_image")
    private Long id;

    @JsonIgnore
    private String type;

    @JsonIgnore
    @NotNull
    private byte[] data;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonView({ JsonViews.ImageBasic.class })
    @JsonUnwrapped
    Product idImageProduct;

    @OneToOne()
    @JsonView({ JsonViews.ImageBasic.class })
    @JsonUnwrapped
    NewsPost idImageNews;

    public Image() {
    }

    public Image(String type, byte[] data, Product idImageProduct) {
        this.type = type;
        this.data = data;
        this.idImageProduct = idImageProduct;
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

    public Product getIdImageProduct() {
        return idImageProduct;
    }

    public void setIdImageProduct(Product idImageProduct) {
        this.idImageProduct = idImageProduct;
    }

    public NewsPost getIdImageNews() {
        return idImageNews;
    }

    public void setIdImageNews(NewsPost idImageNews) {
        this.idImageNews = idImageNews;
    }
}
