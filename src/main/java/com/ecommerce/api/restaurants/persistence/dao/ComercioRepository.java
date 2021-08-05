package com.ecommerce.api.restaurants.persistence.dao;

import com.ecommerce.api.restaurants.domain.dto.Commerce;
import com.ecommerce.api.restaurants.domain.dto.CommerceCourier;
import com.ecommerce.api.restaurants.domain.dto.TypeCommerce;
import com.ecommerce.api.restaurants.domain.repository.CommerceRepository;
import com.ecommerce.api.restaurants.persistence.crud.ComercioCrudRepository;
import com.ecommerce.api.restaurants.persistence.crud.ComercioMensajeroCrudRepository;
import com.ecommerce.api.restaurants.persistence.crud.TipoComercioCrudRepository;
import com.ecommerce.api.restaurants.persistence.entity.*;
import com.ecommerce.api.restaurants.persistence.mapper.CommerceMapper;

import com.ecommerce.api.restaurants.persistence.mapper.TypeCommerceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComercioRepository implements CommerceRepository {

    @Autowired
    private ComercioCrudRepository crudRepository;

    @Autowired
    private TipoComercioCrudRepository tipoCrudRepository;

    @Autowired
    private ComercioMensajeroCrudRepository comercioMensajeroCrudRepository;

    @Autowired
    private CommerceMapper mapper;

    @Autowired
    private TypeCommerceMapper typeCommerceMapper;

    @Override
    public Optional<List<Commerce>> getAll() {
        List<Comercio> entities = (List<Comercio>) crudRepository.findAll();
        return Optional.of(mapper.toCommerces(entities));
    }

    @Override
    public Optional<List<TypeCommerce>> getAllTypeCommerce() {
        List<TipoComercio> entities = (List<TipoComercio>) tipoCrudRepository.findAll();
        return Optional.of(typeCommerceMapper.toTypesCommerces(entities));
    }

    @Override
    public Optional<List<TypeCommerce>> getAllTypeCommerceActive() {
        List<TipoComercio> entities = (List<TipoComercio>) tipoCrudRepository.findByEstadoTrueOrderById();
        return Optional.of(typeCommerceMapper.toTypesCommerces(entities));
    }

    public Optional<List<Commerce>> getAllByCategory(int category) {
     List<Comercio> entities =  crudRepository.findByIdTipoComercioAndUsuarioActivoTrueOrderByUrl(category);
        return Optional.ofNullable(mapper.toCommerces(entities));
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
    public boolean addCourier(CommerceCourier dto){
        ComercioMensajeroPK id = new ComercioMensajeroPK(dto.getCommerceId(),dto.getCourierId());
        if(this.comercioMensajeroCrudRepository.findById(id).isPresent()){
            return true;
        }else{
            ComercioMensajero toInsert= new ComercioMensajero(id);
           if(Optional.ofNullable(this.comercioMensajeroCrudRepository.save(toInsert)).isPresent()){
               return true;

            }
        }
      return false;
    }


    @Override
    public Optional<Commerce> update(Commerce dto) {

        Comercio entity=  crudRepository.findById(dto.getId()).map(comercio->{
            Comercio comercioToSave = mapper.toComercio(dto);
            comercioToSave.setMensajeros(comercio.getMensajeros());
            comercioToSave.setCategoriaProductos(comercio.getCategoriaProductos());
            return comercioToSave;
        }).get();

        return Optional.of(mapper.toCommerce(crudRepository.save(entity)));

        //return Optional.empty();
    }

    @Override
    public void delete(int id) {

    }

}
