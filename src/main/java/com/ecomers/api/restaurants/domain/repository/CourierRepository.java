package com.ecomers.api.restaurants.domain.repository;

import com.ecomers.api.restaurants.domain.dto.Commerce;
import com.ecomers.api.restaurants.domain.dto.Courier;

import java.util.List;
import java.util.Optional;

public interface CourierRepository {
    Optional<List<Courier>> getAll();
    Optional<Courier> getCourierById(int id);
    Optional<List<Courier>> getAllByCommerce(int commerceId);
    Optional<Courier> getByEmail(String email);
    Optional<Courier>  save(Courier dto);
    Optional<Courier>  update(Courier dto);
    void delete(int id);
}
