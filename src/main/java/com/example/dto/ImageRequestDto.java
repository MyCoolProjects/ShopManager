package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageRequestDto {
    
    private String payload;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("newspost_id")
    private Long newsPostId;
}
