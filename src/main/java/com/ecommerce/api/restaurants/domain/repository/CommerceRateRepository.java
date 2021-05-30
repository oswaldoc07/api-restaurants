package com.ecommerce.api.restaurants.domain.repository;

import java.util.List;
import java.util.Optional;

import com.ecommerce.api.restaurants.domain.dto.CommerceRate;

public interface CommerceRateRepository {

    Optional<List<CommerceRate>> getAll();
    Optional<List<CommerceRate>> getAllByCommerce(int commerceId);
    Optional<CommerceRate> getCommerceRateById(int id);
    CommerceRate save(CommerceRate dto);
    Optional<CommerceRate> update(CommerceRate dto);
    void delete(int id);
}
