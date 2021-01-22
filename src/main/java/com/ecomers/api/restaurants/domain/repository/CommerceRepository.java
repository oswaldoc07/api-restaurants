package com.ecomers.api.restaurants.domain.repository;

import com.ecomers.api.restaurants.domain.dto.Commerce;
import com.ecomers.api.restaurants.domain.dto.Product;

import java.util.List;
import java.util.Optional;

public interface CommerceRepository {
    Optional<List<Commerce>> getAllByType(int id);
    List<Commerce> getAll();
    Optional<Commerce> getCommerce(int id);
    Optional<Commerce> getByUrl(String url);
    Product save(Commerce dto);
    Product update(Commerce dto);
    void delete(int id);
}
