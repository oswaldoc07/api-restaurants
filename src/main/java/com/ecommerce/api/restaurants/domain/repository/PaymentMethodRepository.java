package com.ecommerce.api.restaurants.domain.repository;


import java.util.List;
import java.util.Optional;

import com.ecommerce.api.restaurants.domain.dto.PaymentMethod;

public interface PaymentMethodRepository {
    Optional<List<PaymentMethod>> getAll();
    Optional<List<PaymentMethod>> getAllByCommerce();
}
