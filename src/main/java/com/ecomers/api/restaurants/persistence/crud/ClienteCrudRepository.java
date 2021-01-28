package com.ecomers.api.restaurants.persistence.crud;

import com.ecomers.api.restaurants.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente,Integer> {
    Optional<Cliente> findByIdCliente(Integer id);
    Optional<Cliente> findByCorreo(String correo);
    Optional<Cliente> findByCelular(String celular);
}
