package com.ecommerce.api.restaurants.persistence.crud;

import com.ecommerce.api.restaurants.persistence.entity.ComercioMensajero;
import com.ecommerce.api.restaurants.persistence.entity.ComercioMensajeroPK;
import org.springframework.data.repository.CrudRepository;

public interface ComercioMensajeroCrudRepository extends CrudRepository<ComercioMensajero, ComercioMensajeroPK>{
}
