package com.ecomers.api.restaurants.domain.repository;

import com.ecomers.api.restaurants.domain.dto.CommerceRate;


import java.util.List;
import java.util.Optional;

public interface CommerceRateRepository {

    Optional<List<CommerceRate>> getAll();
    Optional<List<CommerceRate>> getAllByCommerce(int commerceId);
    Optional<CommerceRate> getCommerceRateById(int id);
    CommerceRate save(CommerceRate dto);
    Optional<CommerceRate> update(CommerceRate dto);
    void delete(int id);
}
