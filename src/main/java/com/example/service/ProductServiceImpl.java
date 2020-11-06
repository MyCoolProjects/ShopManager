package com.example.service;

import com.example.entity.Product;
import com.example.entity.Specification_value;
import com.example.repository.CategoryRepository;
import com.example.repository.ProductRepository;
import com.example.repository.Specification_nameRepository;
import com.example.repository.Specification_valueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Specification_nameRepository specification_nameRepository;

    @Autowired
    Specification_valueRepository specification_valueRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Product saveProduct(Product product) {
        Product newProduct = productRepository.save(product);
        for(Specification_value spec : product.getSpecifications()) {
            if(product.getProduct_category().getId() == specification_nameRepository.getIdCategory(spec.getId_spec_name().getId_name())) {
                Specification_value specification_value = spec;
                specification_value.setId_spec_product(product);
                specification_valueRepository.save(specification_value);
            }
        }
        return newProduct;
    }
}
