package com.example.form;

public class FormImageGET {
    private Long id;

    private Long id_product;

    private Long id_news;

    public FormImageGET() {
    }

    public FormImageGET(Long id, Long id_product) {
        this.id = id;
        this.id_product = id_product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public Long getId_news() {
        return id_news;
    }

    public void setId_news(Long id_news) {
        this.id_news = id_news;
    }
}
