package com.ecommerce.api.restaurants.persistence.dao;

import com.ecommerce.api.restaurants.domain.dto.Parameter;
import com.ecommerce.api.restaurants.domain.repository.ParameterRepository;
import com.ecommerce.api.restaurants.persistence.crud.ParametroCrudRepository;
import com.ecommerce.api.restaurants.persistence.mapper.ParametersMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ParametroRepository implements ParameterRepository {

    @Autowired
    private ParametroCrudRepository crudRepository;

    @Autowired
    private ParametersMapper mapper;

    @Override
    public Optional<Parameter> findByCode(String codigo){
        return crudRepository.findByCodigo(codigo).map(parametro -> mapper.toParameter(parametro));
    }

}
