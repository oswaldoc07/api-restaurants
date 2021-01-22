package com.ecomers.api.restaurants.persistence.dao;

import com.ecomers.api.restaurants.domain.dto.Commerce;
import com.ecomers.api.restaurants.domain.dto.Product;
import com.ecomers.api.restaurants.domain.repository.CommerceRepository;
import com.ecomers.api.restaurants.persistence.crud.ComercioCrudRepository;
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
    private ComercioCrudRepository comercioCrudRepository;

    @Autowired
    private CommerceMapper mapper;

    @Override
    public Optional<List<Commerce>> getAllByType(int id) {
        return Optional.empty();
    }

    @Override
    public List<Commerce> getAll() {
        List<Comercio> entities = (List<Comercio>) comercioCrudRepository.findAll();
        return mapper.toCommerces(entities);
    }

    @Override
    public Optional<Commerce> getCommerce(int id) {
        Commerce commerce= comercioCrudRepository.findById(id).map(producto -> mapper.toCommerce(producto)).get();
        return Optional. of(commerce);
    }

    @Override
    public Optional<Commerce> getByUrl(String url) {
        Commerce commerce= comercioCrudRepository.findByUrl(url).map(producto -> mapper.toCommerce(producto)).get();
        return Optional. of(commerce);

    }

    @Override
    public Product save(Commerce dto) {
        return null;
    }

    @Override
    public Product update(Commerce dto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
