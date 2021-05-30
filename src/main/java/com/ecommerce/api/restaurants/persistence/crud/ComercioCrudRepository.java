package com.ecommerce.api.restaurants.persistence.crud;


import org.springframework.data.repository.CrudRepository;

import com.ecommerce.api.restaurants.persistence.entity.Comercio;

import java.util.Optional;

public interface ComercioCrudRepository extends CrudRepository<Comercio,Integer> {
    Optional<Comercio> findByUrl(String url);
    Optional<Comercio> findByUsuarioCorreo(String correo);

}
