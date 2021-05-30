package com.ecommerce.api.restaurants.domain.service;



import com.ecommerce.api.restaurants.domain.dto.Product;
import com.ecommerce.api.restaurants.domain.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;



    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCommerceAndCategory(int commerce,int categoryId) {
        return productRepository.getByCommerceAndCategory(commerce,categoryId);
    }

    public Optional<List<Product>> getByCommercePromotions(int commerce) {
        return productRepository.getByCommercePromotions(commerce);
    }

    public  Optional<List<Product>> getAllByCommerce(int commerceId) {
        return productRepository.getAllByCommerce(commerceId);
    }


    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product product) {
        return productRepository.update(product);
    }
    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
