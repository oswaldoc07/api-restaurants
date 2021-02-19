package com.ecomers.api.restaurants.domain.repository;

import com.ecomers.api.restaurants.domain.dto.Parameter;

import java.util.Optional;

public interface ParameterRepository {

    Optional<Parameter> findByCode(String code);
}
