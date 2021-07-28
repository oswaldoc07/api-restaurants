package com.ecommerce.api.restaurants.persistence.crud;

import com.ecommerce.api.restaurants.persistence.entity.Mensajero;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MensajeroCrudRepository extends CrudRepository<Mensajero,Integer> {
    Optional<Mensajero> findByUsuarioCorreo(String correo);
}
