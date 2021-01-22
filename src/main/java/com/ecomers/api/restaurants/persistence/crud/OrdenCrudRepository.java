package com.ecomers.api.restaurants.persistence.crud;



import com.ecomers.api.restaurants.persistence.entity.Orden;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrdenCrudRepository extends CrudRepository<Orden, Integer> {
    Optional<List<Orden>> findByIdUsuario(String idUsuario);
}
