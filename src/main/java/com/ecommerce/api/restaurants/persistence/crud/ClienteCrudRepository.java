package com.ecommerce.api.restaurants.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.api.restaurants.persistence.entity.Cliente;

import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente,Integer> {
    Optional<Cliente> findByUsuarioCorreo(String correo);
    Optional<Cliente> findByUsuarioCelular(String celular);
}
