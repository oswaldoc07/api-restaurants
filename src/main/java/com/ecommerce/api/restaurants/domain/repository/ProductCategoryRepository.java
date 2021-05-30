package com.ecommerce.api.restaurants.domain.repository;


import java.util.List;

import com.ecommerce.api.restaurants.domain.dto.ProductCategory;

public interface ProductCategoryRepository {

    List<ProductCategory> getAll();

    List<ProductCategory> getAllByCommerce(int commerceId);

}



