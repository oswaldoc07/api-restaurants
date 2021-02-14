package com.ecomers.api.restaurants.domain.repository;

import com.ecomers.api.restaurants.domain.dto.Client;
import com.ecomers.api.restaurants.domain.dto.PaymentType;

import java.util.List;
import java.util.Optional;

public interface PaymentTypeRepository {
    Optional<List<PaymentType>> getAll();
    Optional<List<PaymentType>> getAllByCommerce();
}
