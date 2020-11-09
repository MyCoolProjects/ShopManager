package com.example.form;

public class FormNews {

    private String title;

    private String description;

    public FormNews() {
    }

    public FormNews(String title, String description) {
        this.title = title;
        this.description = description;
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

}
