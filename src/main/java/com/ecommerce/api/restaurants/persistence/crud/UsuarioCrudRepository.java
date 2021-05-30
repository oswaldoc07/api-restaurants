package com.ecommerce.api.restaurants.persistence.crud;

import org.springframework.data.repository.CrudRepository;


import com.ecommerce.api.restaurants.persistence.entity.Usuario;

import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario,Integer> {
    Optional<Usuario> findByCorreo(String correo);
    Optional<Usuario> findByCelular(String celular);
}
