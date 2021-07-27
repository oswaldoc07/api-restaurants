package com.ecommerce.api.restaurants.persistence.crud;

import com.ecommerce.api.restaurants.persistence.entity.Mensajero;

import com.ecommerce.api.restaurants.persistence.entity.Orden;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MensajeroCrudRepository extends CrudRepository<Mensajero,Integer> {
    Optional<Mensajero> findByUsuarioCorreo(String correo);

    @Query(value = "SELECT NEW com.ecommerce.api.restaurants.persistence.entity.Mensajero(COUNT(*), sum(O.tiempoEnvio)) FROM Orden O  WHERE  O.mensajero.id =:idMensajero" +
            " AND estado='RUT'")
    Mensajero numberOrdersProcess(@Param("idMensajero")Integer idMensajero);

}
