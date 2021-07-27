package com.ecommerce.api.restaurants.domain.repository;

import java.util.List;
import java.util.Optional;

import com.ecommerce.api.restaurants.domain.dto.Courier;

public interface CourierRepository {
    Optional<List<Courier>> getAll();
    Optional<Courier> getCourierById(int id);
    Optional<List<Courier>> getAllByCommerce(int commerceId);
    Optional<List<Courier>> getAllByCommerceWithPendingDelivery(int commerceId);
    Optional<Courier> getByEmail(String email);
    Optional<Courier>  save(Courier dto);
    Optional<Courier>  update(Courier dto);
    void delete(int id);
}
