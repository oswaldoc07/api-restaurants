package com.ecommerce.api.restaurants.persistence.crud;

import com.ecommerce.api.restaurants.persistence.entity.CategoriaProducto;
import com.ecommerce.api.restaurants.persistence.entity.Cliente;
import com.ecommerce.api.restaurants.persistence.entity.ComercioCategoriaProducto;
import com.ecommerce.api.restaurants.persistence.entity.ComercioCategoriaProductoPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ComercioCategoriaProductoCrudRepository  extends CrudRepository<ComercioCategoriaProducto, ComercioCategoriaProductoPK> {

    Optional<List<ComercioCategoriaProducto>> findByIdIdComercio(int commerce);

}


