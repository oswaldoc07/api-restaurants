package com.ecomers.api.restaurants.persistence.crud;

import com.ecomers.api.restaurants.domain.dto.Courier;
import com.ecomers.api.restaurants.persistence.entity.Cliente;
import com.ecomers.api.restaurants.persistence.entity.Comercio;
import com.ecomers.api.restaurants.persistence.entity.Mensajero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MensajeroCrudRepository extends CrudRepository<Mensajero,Integer> {
    Optional<List<Mensajero>> findByIdComercio(int id_comercio);
    Optional<Mensajero> findByUsuarioCorreo(String correo);
}
