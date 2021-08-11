package com.ecommerce.api.restaurants.persistence.repository.impl;

import com.ecommerce.api.restaurants.domain.dto.ProductCategory;
import com.ecommerce.api.restaurants.persistence.repository.IProductCategoryRepository;
import com.ecommerce.api.restaurants.persistence.crud.CategoriaProductoCrudRepository;
import com.ecommerce.api.restaurants.persistence.crud.ComercioCrudRepository;
import com.ecommerce.api.restaurants.persistence.entity.CategoriaProducto;
import com.ecommerce.api.restaurants.persistence.entity.Comercio;
import com.ecommerce.api.restaurants.persistence.mapper.ProductCategoryMapper;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductCategoryRepository implements IProductCategoryRepository {

    @Autowired
    private CategoriaProductoCrudRepository crudRepository;

    @Autowired
    private ComercioCrudRepository comercioCrudRepository;




    @Autowired
    private ProductCategoryMapper mapper;

    @Override
    public List<ProductCategory> getAll() {
        List<CategoriaProducto> entities = (List<CategoriaProducto>) crudRepository.findAll();
        return mapper.toCategories(entities);
    }


    @Override
    public List<ProductCategory> getAllByCommerce(int commerceId) {
        Optional<Comercio> commerce =  comercioCrudRepository.findById(commerceId);
        Hibernate.initialize(commerce.get().getCategoriaProductos());
        List<CategoriaProducto> categoriaProductos = commerce.get().getCategoriaProductos();
        return mapper.toCategories(categoriaProductos);

    }




}
