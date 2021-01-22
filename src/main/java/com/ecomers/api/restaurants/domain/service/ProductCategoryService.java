package com.ecomers.api.restaurants.domain.service;

import com.ecomers.api.restaurants.domain.dto.ProductCategory;
import com.ecomers.api.restaurants.domain.repository.ProductCategoryRepository;
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

}
