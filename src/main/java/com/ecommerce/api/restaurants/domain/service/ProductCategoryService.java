package com.ecommerce.api.restaurants.domain.service;

import com.ecommerce.api.restaurants.domain.dto.ProductCategory;
import com.ecommerce.api.restaurants.domain.repository.ProductCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;



    public List<ProductCategory> getAll() {
        return repository.getAll();
    }

    public List<ProductCategory> getAllByCommerce(int comeerceId) {
        return repository.getAllByCommerce(comeerceId);
    }

}
