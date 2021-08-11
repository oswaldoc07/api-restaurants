package com.ecommerce.api.restaurants.persistence.repository.impl;

import com.ecommerce.api.restaurants.domain.dto.Parameter;
import com.ecommerce.api.restaurants.persistence.repository.IParameterRepository;
import com.ecommerce.api.restaurants.persistence.crud.ParametroCrudRepository;
import com.ecommerce.api.restaurants.persistence.mapper.ParametersMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ParameterRepository implements IParameterRepository {

    @Autowired
    private ParametroCrudRepository crudRepository;

    @Autowired
    private ParametersMapper mapper;

    @Override
    public Optional<Parameter> findByCode(String codigo){
        return crudRepository.findByCodigo(codigo).map(parametro -> mapper.toParameter(parametro));
    }

}
