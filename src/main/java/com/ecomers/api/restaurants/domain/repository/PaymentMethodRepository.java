package com.ecomers.api.restaurants.domain.repository;


import com.ecomers.api.restaurants.domain.dto.PaymentMethod;


import java.util.List;
import java.util.Optional;

public interface PaymentMethodRepository {
    Optional<List<PaymentMethod>> getAll();
    Optional<List<PaymentMethod>> getAllByCommerce();
}
