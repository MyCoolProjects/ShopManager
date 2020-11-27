package com.example.service;

import com.example.entity.Product;
import com.example.entity.SpecificationValue;
import com.example.repository.CategoryRepository;
import com.example.repository.ProductRepository;
import com.example.repository.SpecificationNameRepository;
import com.example.repository.SpecificationValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SpecificationNameRepository specificationNameRepository;

    @Autowired
    SpecificationValueRepository specificationValueRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public Product saveProduct(Product product) {
        for (SpecificationValue spec : product.getSpecifications()) {
            System.out.println(product.getProductCategory().getId());
            System.out.println(specificationNameRepository.getOne(spec.getId()).getIdCategory().getId());
            if (product.getProductCategory().getId() != specificationNameRepository.getOne(spec.getId()).getIdCategory().getId()) {
                return null;
            }
        }
        Product newProduct = productRepository.save(product);
        for (SpecificationValue spec : product.getSpecifications()) {
            SpecificationValue specificationValue = spec;
            specificationValue.setIdSpecProduct(product);
            specificationValueRepository.save(specificationValue);
        }
        return newProduct;
    }
}
