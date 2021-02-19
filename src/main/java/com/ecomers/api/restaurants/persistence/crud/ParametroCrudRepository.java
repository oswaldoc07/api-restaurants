package com.ecomers.api.restaurants.persistence.crud;

import com.ecomers.api.restaurants.persistence.entity.Orden;
import com.ecomers.api.restaurants.persistence.entity.Parametro;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ParametroCrudRepository extends CrudRepository<Parametro,Integer> {

    Optional<Parametro> findByCodigo(String codigo);
}
