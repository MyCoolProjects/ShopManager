package com.example.service;

import com.example.entity.Product;
import com.example.entity.Specification_value;
import com.example.repository.ProductRepository;
import com.example.repository.Specification_valueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Specification_valueRepository specification_valueRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
        for(int i=0; i<product.getSpecifications().size(); i++) {
            Specification_value specification_value = product.getSpecifications().get(i);
            specification_value.setId_spec_product(product);
            specification_valueRepository.save(specification_value);
        }
    }
}
