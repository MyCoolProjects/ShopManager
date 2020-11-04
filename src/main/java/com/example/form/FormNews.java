package com.example.form;

public class FormNews {

    private String title;

    private String description;

    private Long id_image_news;

    public FormNews() {
    }

    public FormNews(String title, String description, Long id_image_news) {
        this.title = title;
        this.description = description;
        this.id_image_news = id_image_news;
    }

    public String getName() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId_image_news() {
        return id_image_news;
    }

    public void setId_image_news(Long id_image_news) {
        this.id_image_news = id_image_news;
    }
}
