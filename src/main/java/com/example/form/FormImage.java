package com.example.form;

public class FormImage {

    private String image;

    private Long id_image_product;

    public FormImage() {
    }

    public FormImage(String image, Long id_image_product) {
        this.image = image;
        this.id_image_product = id_image_product;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId_image_product() {
        return id_image_product;
    }

    public void setId_image_product(Long id_image_product) {
        this.id_image_product = id_image_product;
    }

}
