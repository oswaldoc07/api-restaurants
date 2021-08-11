package com.ecommerce.api.restaurants.persistence.repository;

import java.util.Optional;

import com.ecommerce.api.restaurants.domain.dto.Parameter;

public interface IParameterRepository {

    Optional<Parameter> findByCode(String code);
}
