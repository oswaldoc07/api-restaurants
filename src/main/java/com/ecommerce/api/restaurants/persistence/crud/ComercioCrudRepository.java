package com.ecommerce.api.restaurants.persistence.crud;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ecommerce.api.restaurants.persistence.entity.Comercio;

import java.util.List;
import java.util.Optional;

public interface ComercioCrudRepository extends CrudRepository<Comercio,Integer> {
    Optional<Comercio> findByUrl(String url);
    Optional<Comercio> findByUsuarioCorreo(String correo);
    List<Comercio> findByIdTipoComercioAndUsuarioActivoTrueOrderByUrl(int idCategoria);

    /*@Query(value = "select C FROM Comercio o WHERE o.idCliente=:idCliente " +
            " AND ( o.estado!='ENT' AND o.estado!='REC') ORDER by o.fechaIngreso DESC")
    List<Comercio> findBAllPersonalized();*/

}
