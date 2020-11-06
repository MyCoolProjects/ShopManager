package com.example.service;

import com.example.entity.Image;
import com.example.form.FormImageGET;
import com.example.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    ImageRepository imageRepository;

    public List<FormImageGET> getImagesId() {
        List<FormImageGET> images = new ArrayList<>();
        for(long i=1; i<imageRepository.findAll().size(); i++) {
            Image img = imageRepository.getOne(i);
            if(img.getId_image_product() == null) {
                images.add(new FormImageGET(img.getId(), img.getId_image_product().getId()));
            }
            if(img.getId_image_news() == null) {
                images.add(new FormImageGET(img.getId(), img.getId_image_news().getId()));
            }
        }
        return images;
    }
}
