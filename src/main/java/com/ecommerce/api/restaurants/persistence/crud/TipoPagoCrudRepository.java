package com.ecommerce.api.restaurants.persistence.crud;


import org.springframework.data.repository.CrudRepository;

import com.ecommerce.api.restaurants.persistence.entity.TipoPago;

public interface TipoPagoCrudRepository extends CrudRepository<TipoPago,String> {
}
