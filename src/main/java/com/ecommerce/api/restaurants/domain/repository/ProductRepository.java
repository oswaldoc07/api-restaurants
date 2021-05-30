package com.ecommerce.api.restaurants.domain.repository;



import java.util.List;
import java.util.Optional;

import com.ecommerce.api.restaurants.domain.dto.Product;

public interface ProductRepository {
    Optional<List<Product>> getByCommercePromotions(int commerce);
    Optional<List<Product>> getByCommerceAndCategory(int commerce,int categoryId);
    Optional<List<Product>>  getAllByCommerce(int commerceId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int id);
    Product save(Product dto);
    Product update(Product dto);
    void delete(int id);
}