package com.example.repository;

import com.example.entity.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query("SELECT img FROM Image img")
    public List<Image> getIds();
}
