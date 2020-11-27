package com.example.entity;

import com.example.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "NewsPosts")
public class NewsPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({ JsonViews.NewsPostBasic.class, JsonViews.ImageBasic.class })
    private Long id;

    @NotBlank
    private String title;

    private String description;

    @JsonView({ JsonViews.NewsPostBasic.class })
    @OneToOne(mappedBy = "idImageNews", cascade = CascadeType.REMOVE)
    Image image;

    public NewsPost() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImages(Image image) {
        this.image = image;
    }
}
