package com.ecommerce.api.restaurants.domain.repository;

import com.ecommerce.api.restaurants.domain.dto.TypeCommerce;

import java.util.List;
import java.util.Optional;

public interface TypeCommerceRepository {

    public Optional<List<TypeCommerce>> getAll();
}
