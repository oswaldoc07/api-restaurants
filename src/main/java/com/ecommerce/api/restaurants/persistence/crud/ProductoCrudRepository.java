package com.ecommerce.api.restaurants.persistence.crud;



import org.springframework.data.repository.CrudRepository;

import com.ecommerce.api.restaurants.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
                   //AndPromotionFalseOrderByNombreAsc

    Optional<List<Producto>> findByIdComercioAndIdCategoriaOrderByNombreAsc(int commerce,int idCategoria);
    Optional<List<Producto>> findByIdComercioOrderByNombreAsc(int commerceId);
    Optional<List<Producto>> findByIdComercioAndPromocionTrueOrderByNombreAsc(int commerce);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
