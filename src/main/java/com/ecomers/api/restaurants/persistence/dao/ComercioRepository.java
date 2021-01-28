package com.ecomers.api.restaurants.persistence.dao;

import com.ecomers.api.restaurants.domain.dto.Client;
import com.ecomers.api.restaurants.domain.dto.Commerce;
import com.ecomers.api.restaurants.domain.dto.Product;
import com.ecomers.api.restaurants.domain.repository.CommerceRepository;
import com.ecomers.api.restaurants.persistence.crud.ComercioCrudRepository;
import com.ecomers.api.restaurants.persistence.entity.Cliente;
import com.ecomers.api.restaurants.persistence.entity.Comercio;
import com.ecomers.api.restaurants.persistence.entity.Producto;
import com.ecomers.api.restaurants.persistence.mapper.CommerceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ComercioRepository implements CommerceRepository {

    @Autowired
    private ComercioCrudRepository crudRepository;

    @Autowired
    private CommerceMapper mapper;


    @Override
    public Optional<List<Commerce>> getAll() {
        List<Comercio> entities = (List<Comercio>) crudRepository.findAll();
        return Optional.of(mapper.toCommerces(entities));
    }

    @Override
    public Optional<Commerce> getById(int id) {
        return crudRepository.findByIdComercio(id).map(commerce -> mapper.toCommerce(commerce));
        /*Commerce dto= crudRepository.findById(id).map(commerce -> mapper.toCommerce(commerce)).get();
        return Optional.of(dto);*/
    }

    @Override
    public Optional<Commerce> getByUrl(String url) {
        return crudRepository.findByUrl(url).map(commerce -> mapper.toCommerce(commerce));
        /*Commerce dto= crudRepository.findByUrl(url).map(commerce -> mapper.toCommerce(commerce)).get();
        return Optional. of(dto);*/

    }

    @Override
    public Optional<Commerce> getByEmail(String email) {
        return crudRepository.findByCorreo(email).map(commerce -> mapper.toCommerce(commerce));
        /*Commerce dto= crudRepository.findByCorreo(email).map(commerce -> mapper.toCommerce(commerce)).get();
        return Optional. of(dto);*/
    }

    @Override
    public  Optional<Commerce> save(Commerce dto) {
        Comercio entity = mapper.toComercio(dto);
        return Optional.of(mapper.toCommerce(crudRepository.save(entity)));
    }


    @Override
    public Optional<Commerce> update(Commerce dto) {
        return Optional.empty();
    }

    @Override
    public void delete(int id) {

    }

}
