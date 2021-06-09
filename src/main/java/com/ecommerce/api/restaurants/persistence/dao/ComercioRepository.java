package com.ecommerce.api.restaurants.persistence.dao;

import com.ecommerce.api.restaurants.domain.dto.Commerce;
import com.ecommerce.api.restaurants.domain.repository.CommerceRepository;
import com.ecommerce.api.restaurants.persistence.crud.ComercioCrudRepository;
import com.ecommerce.api.restaurants.persistence.entity.Comercio;
import com.ecommerce.api.restaurants.persistence.mapper.CommerceMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public Optional<List<Commerce>> getAllByCategory(int category) {
     List<Comercio> entities =  crudRepository.findByIdCategoria(category);
        return Optional.of(mapper.toCommerces(entities));
    }
    @Override
    public Optional<Commerce> getById(int id) {
        return crudRepository.findById(id).map(commerce -> mapper.toCommerce(commerce));
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
        return crudRepository.findByUsuarioCorreo(email).map(comercio -> mapper.toCommerce(comercio));
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
