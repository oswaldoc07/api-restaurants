package com.ecomers.api.restaurants.domain.repository;



import com.ecomers.api.restaurants.domain.dto.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<List<Product>> getByCommercePromotions(int commerce);
    Optional<List<Product>> getByCommerceAndCategory(int commerce,int categoryId);
    List<Product> getAll();
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    Product update(Product product);
    void delete(int productId);
}