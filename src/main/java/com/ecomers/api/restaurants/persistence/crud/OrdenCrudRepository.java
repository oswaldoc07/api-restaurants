package com.ecomers.api.restaurants.persistence.crud;



import com.ecomers.api.restaurants.domain.dto.Order;
import com.ecomers.api.restaurants.persistence.entity.Orden;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface OrdenCrudRepository extends CrudRepository<Orden, Integer> {
    Optional<List<Orden>> findByIdCliente(Integer idUsuario);
    Optional<List<Orden>> findByIdComercioAndEstadoOrderByFechaIngresoDesc(Integer comercio,String estado);
    Optional<List<Orden>> findByMensajeroIdAndEstado(Integer mensajero,String estado);
    Optional<List<Orden>> findByIdComercioAndEstadoAndFechaIngreso(Integer comercio,String estado, Date today);
    Optional<Orden> findByIdAndIdCliente(Integer id,Integer clienteId);
    Optional<Orden> findByIdAndMensajeroId(int id, int idMensajero);
}
