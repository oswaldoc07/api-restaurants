package com.ecommerce.api.restaurants.persistence.repository;


import java.util.List;

import com.ecommerce.api.restaurants.domain.dto.ProductCategory;

public interface IProductCategoryRepository {

    List<ProductCategory> getAll();

    List<ProductCategory> getAllByCommerce(int commerceId);

}



