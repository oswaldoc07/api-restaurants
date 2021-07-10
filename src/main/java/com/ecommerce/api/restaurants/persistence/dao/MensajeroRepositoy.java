package com.ecommerce.api.restaurants.persistence.dao;


import com.ecommerce.api.restaurants.domain.dto.Courier;
import com.ecommerce.api.restaurants.domain.repository.CourierRepository;
import com.ecommerce.api.restaurants.persistence.crud.ComercioCrudRepository;
import com.ecommerce.api.restaurants.persistence.crud.MensajeroCrudRepository;
import com.ecommerce.api.restaurants.persistence.entity.Comercio;
import com.ecommerce.api.restaurants.persistence.entity.Mensajero;
import com.ecommerce.api.restaurants.persistence.mapper.CourierMapper;


import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class MensajeroRepositoy  implements CourierRepository {


    @Autowired
    private MensajeroCrudRepository crudRepository;

    @Autowired
    private ComercioCrudRepository comercioCrudRepository;

    @Autowired
    private CourierMapper mapper;

    @Override
    public  Optional<List<Courier>> getAll() {
        List<Mensajero> entities = (List<Mensajero>) crudRepository.findAll();
        return Optional.of(mapper.toCouriers(entities));
    }

    @Override
    public Optional<List<Courier>> getAllByCommerce(int commerceId) {
    try{
    Optional<Comercio> comercio = comercioCrudRepository.findById(commerceId);
    Hibernate.initialize(comercio.get().getMensajeros());
    List<Mensajero> entities =(comercio.get().getMensajeros());
    return Optional.ofNullable(mapper.toCouriers(entities));
    }catch (Exception e){
        return Optional.empty();
    }

    }

    @Override
    public Optional<Courier> getCourierById(int id) {
        return crudRepository.findById(id).map(entity -> mapper.toCourier(entity));

    }

    @Override
    public Optional<Courier> getByEmail(String email) {
        return crudRepository.findByUsuarioCorreo(email).map(mensajero -> mapper.toCourier(mensajero));
    }




    @Override
    public  Optional<Courier> save(Courier dto) {
        Mensajero entity = mapper.toMensajero(dto);
        return Optional.of(mapper.toCourier(crudRepository.save(entity)));
    }

    @Override
    public Optional<Courier>  update(Courier changes) {
        /*Mensajero entity=  crudRepository.findById(changes.getId()).map(mensajero->{

           mensajero.setPlaca(changes.getLicensePlate());
           mensajero.setTipoVehiculo(changes.getVehicleType());
           mensajero.getUsuario().setNombre(changes.getDisplayName());
           mensajero.getUsuario().setIdRol(changes.getRole());
           mensajero.getUsuario().setActivo(changes.getActive());
           mensajero.getUsuario().setCelular(changes.getPhoneNumber());
           mensajero.getUsuario().setImagen(changes.getPhotoURL());
          return  mensajero
        }).get();*/

        return Optional.of(mapper.toCourier(crudRepository.save(mapper.toMensajero(changes))));

    }

    @Override
    public void delete(int id) {
        this.crudRepository.deleteById(id);
    }
}
