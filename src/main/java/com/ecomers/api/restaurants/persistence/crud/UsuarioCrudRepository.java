package com.ecomers.api.restaurants.persistence.crud;

import com.ecomers.api.restaurants.persistence.entity.Cliente;
import com.ecomers.api.restaurants.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario,Integer> {
    Optional<Usuario> findByCorreo(String correo);
    Optional<Usuario> findByCelular(String celular);
}
