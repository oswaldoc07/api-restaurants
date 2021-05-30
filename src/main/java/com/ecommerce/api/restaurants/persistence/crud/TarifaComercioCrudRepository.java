package com.ecommerce.api.restaurants.persistence.crud;


import org.springframework.data.repository.CrudRepository;

import com.ecommerce.api.restaurants.persistence.entity.TarifaComercio;

import java.util.List;
import java.util.Optional;

public interface TarifaComercioCrudRepository extends CrudRepository<TarifaComercio,Integer> {
    Optional<List<TarifaComercio>>  findByIdComercioOrderByIdTarifaAsc(int commerceId);
}
