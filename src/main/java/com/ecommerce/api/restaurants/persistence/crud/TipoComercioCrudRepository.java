package com.ecommerce.api.restaurants.persistence.crud;

import com.ecommerce.api.restaurants.persistence.entity.TipoComercio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TipoComercioCrudRepository extends CrudRepository<TipoComercio, Integer> {

    List<TipoComercio> findByEstadoTrue();
}
