package com.ecommerce.api.restaurants.domain.repository;

import java.util.Optional;

import com.ecommerce.api.restaurants.domain.dto.Parameter;

public interface ParameterRepository {

    Optional<Parameter> findByCode(String code);
}
