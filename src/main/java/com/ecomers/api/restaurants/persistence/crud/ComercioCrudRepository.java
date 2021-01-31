package com.ecomers.api.restaurants.persistence.crud;


import com.ecomers.api.restaurants.persistence.entity.Comercio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ComercioCrudRepository extends CrudRepository<Comercio,Integer> {
    Optional<Comercio> findByUrl(String url);
    Optional<Comercio> findByUsuarioCorreo(String correo);

}
