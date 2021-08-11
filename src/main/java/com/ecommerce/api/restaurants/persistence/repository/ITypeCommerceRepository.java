package com.ecommerce.api.restaurants.persistence.repository;

import com.ecommerce.api.restaurants.domain.dto.TypeCommerce;

import java.util.List;
import java.util.Optional;

public interface ITypeCommerceRepository {

    public Optional<List<TypeCommerce>> getAll();
}
