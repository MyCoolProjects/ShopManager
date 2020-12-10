package com.mycoolprojects.shopmanager.repository;

import com.mycoolprojects.shopmanager.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
