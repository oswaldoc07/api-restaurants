package com.ecomers.api.restaurants.persistence.crud;



import com.ecomers.api.restaurants.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
                   //AndPromotionFalseOrderByNombreAsc

    Optional<List<Producto>> findByIdComercioAndIdCategoriaAndPromocionFalseOrderByNombreAsc(int commerce,int idCategoria);
    Optional<List<Producto>> findByIdComercioAndPromocionTrueOrderByNombreAsc(int commerce);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
