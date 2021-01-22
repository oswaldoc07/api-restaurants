package com.ecomers.api.restaurants.domain.repository;


import com.ecomers.api.restaurants.domain.dto.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository {

    List<ProductCategory> getAll();

}



