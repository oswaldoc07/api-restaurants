package com.ecommerce.api.restaurants.persistence.repository.impl;

import com.ecommerce.api.restaurants.domain.dto.CommerceRate;
import com.ecommerce.api.restaurants.persistence.repository.ICommerceRateRepository;
import com.ecommerce.api.restaurants.persistence.crud.TarifaComercioCrudRepository;
import com.ecommerce.api.restaurants.persistence.entity.TarifaComercio;
import com.ecommerce.api.restaurants.persistence.mapper.CommerceRateMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommerceRateRepository implements ICommerceRateRepository {

    @Autowired
    private CommerceRateMapper mapper;

    @Autowired
    private TarifaComercioCrudRepository crudRepository;


    @Override
    public Optional<List<CommerceRate>> getAll() {
        List<TarifaComercio> entities = (List<TarifaComercio>) crudRepository.findAll();
        return Optional.of(mapper.toCommerceRates(entities));
    }

    @Override
    public Optional<List<CommerceRate>> getAllByCommerce(int commerceId) {
        Optional<List<TarifaComercio>> entities =  crudRepository.findByIdComercioOrderByIdTarifaAsc(commerceId);
        return entities.map(rates -> mapper.toCommerceRates(rates));
    }

    @Override
    public Optional<CommerceRate> getCommerceRateById(int id) {
        return crudRepository.findById(id).map(entity -> mapper.toCommerceRate(entity));
    }

    @Override
    public CommerceRate save(CommerceRate dto) {
        TarifaComercio entity = mapper.toTarifaComercio(dto);
        return mapper.toCommerceRate(crudRepository.save(entity));
    }

    @Override
    public Optional<CommerceRate> update(CommerceRate changes) {
        TarifaComercio entity=  crudRepository.findById(changes.getId()).map(tarifa->{
            tarifa.setDistancia(changes.getDistance());
            tarifa.setTarifa(changes.getRate());
            return tarifa;
        }).get();

        return Optional.of(mapper.toCommerceRate(crudRepository.save(entity)));
    }

    public void delete(int id) {
        crudRepository.deleteById(id);
    }
}
