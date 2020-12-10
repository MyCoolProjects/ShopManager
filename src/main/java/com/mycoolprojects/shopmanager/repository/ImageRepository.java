package com.mycoolprojects.shopmanager.repository;

import com.mycoolprojects.shopmanager.entity.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
