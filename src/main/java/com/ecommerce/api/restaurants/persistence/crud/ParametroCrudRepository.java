package com.ecommerce.api.restaurants.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.api.restaurants.persistence.entity.Parametro;

import java.util.Optional;

public interface ParametroCrudRepository extends CrudRepository<Parametro,Integer> {

    Optional<Parametro> findByCodigo(String codigo);
}
