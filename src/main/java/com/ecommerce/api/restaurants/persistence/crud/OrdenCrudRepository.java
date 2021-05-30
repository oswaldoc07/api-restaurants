package com.ecommerce.api.restaurants.persistence.crud;



import com.ecommerce.api.restaurants.persistence.entity.Orden;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrdenCrudRepository extends CrudRepository<Orden, Integer> {
    Optional<List<Orden>> findByIdCliente(Integer idUsuario);


    @Query(value = "select o FROM Orden o WHERE o.fechaIngreso BETWEEN :startDate AND :endDate " +
            " AND o.idComercio=:commerceId AND o.estado=:state ORDER by o.fechaIngreso ASC")
    Optional<List<Orden>>getAllByCommerceAndState(@Param("commerceId")Integer idComercio, @Param("state")String estado,
                                                   @Param("startDate") LocalDateTime fechaInicio, @Param("endDate")LocalDateTime fechaFin );

    @Query(value = "select o FROM Orden o WHERE o.fechaIngreso BETWEEN :startDate AND :endDate " +
            " AND o.mensajero.id=:courierId AND o.estado=:state ORDER by o.fechaIngreso ASC")
    Optional<List<Orden>> getAllByCourierAndState(@Param("courierId")Integer idMensajero, @Param("state")String estado,
                                                                           @Param("startDate") LocalDateTime fechaInicio, @Param("endDate")LocalDateTime fechaFin );

    Optional<Orden> findByIdAndIdCliente(Integer id,Integer clienteId);
    Optional<Orden> findByIdAndMensajeroId(int id, int idMensajero);
}
