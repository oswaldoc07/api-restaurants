package com.ecommerce.api.restaurants.persistence.repository;


import java.util.List;
import java.util.Optional;

import com.ecommerce.api.restaurants.domain.dto.PaymentMethod;

public interface IPaymentMethodRepository {
    Optional<List<PaymentMethod>> getAll();
    Optional<List<PaymentMethod>> getAllByCommerce();
}
