package com.ecomers.api.restaurants.persistence.dao;

import com.ecomers.api.restaurants.domain.dto.Client;
import com.ecomers.api.restaurants.domain.dto.Courier;
import com.ecomers.api.restaurants.domain.repository.CourierRepository;
import com.ecomers.api.restaurants.persistence.crud.ClienteCrudRepository;
import com.ecomers.api.restaurants.persistence.crud.MensajeroCrudRepository;
import com.ecomers.api.restaurants.persistence.entity.Cliente;
import com.ecomers.api.restaurants.persistence.entity.Mensajero;
import com.ecomers.api.restaurants.persistence.entity.Producto;
import com.ecomers.api.restaurants.persistence.mapper.ClientMapper;
import com.ecomers.api.restaurants.persistence.mapper.CourierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class MensajeroRepositoy  implements CourierRepository {


    @Autowired
    private MensajeroCrudRepository crudRepository;

    @Autowired
    private CourierMapper mapper;

    @Override
    public  Optional<List<Courier>> getAll() {
        List<Mensajero> entities = (List<Mensajero>) crudRepository.findAll();
        return Optional.of(mapper.toCouriers(entities));
    }

    @Override
    public Optional<Courier> getCourierById(int id) {
        return crudRepository.findById(id).map(entity -> mapper.toCourier(entity));

    }

    @Override
    public Optional<List<Courier>> getAllByCommerce(int commerceId) {
        Optional<List<Mensajero>> entities = crudRepository.findByIdComercio(commerceId);
        return entities.map(mensajeros -> mapper.toCouriers(mensajeros));
    }


    @Override
    public  Optional<Courier> save(Courier dto) {
        Mensajero entity = mapper.toMensajero(dto);
        return Optional.of(mapper.toCourier(crudRepository.save(entity)));
    }

    @Override
    public Optional<Courier>  update(Courier changes) {
        return Optional.empty();
    }

    @Override
    public void delete(int id) {
        this.crudRepository.deleteById(id);
    }
}
