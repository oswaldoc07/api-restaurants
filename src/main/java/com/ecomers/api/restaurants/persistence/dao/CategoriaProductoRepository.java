package com.ecomers.api.restaurants.persistence.dao;

import com.ecomers.api.restaurants.domain.dto.Product;
import com.ecomers.api.restaurants.domain.dto.ProductCategory;
import com.ecomers.api.restaurants.domain.repository.ProductCategoryRepository;
import com.ecomers.api.restaurants.domain.service.ProductCategoryService;
import com.ecomers.api.restaurants.persistence.crud.CategoriaProductoCrudRepository;
import com.ecomers.api.restaurants.persistence.entity.CategoriaProducto;
import com.ecomers.api.restaurants.persistence.entity.Producto;
import com.ecomers.api.restaurants.persistence.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaProductoRepository implements ProductCategoryRepository {

    @Autowired
    private CategoriaProductoCrudRepository crudRepository;

    @Autowired
    private ProductCategoryMapper mapper;

    @Override
    public List<ProductCategory> getAll() {
        List<CategoriaProducto> entities = (List<CategoriaProducto>) crudRepository.findAll();
        return mapper.toCategories(entities);
    }

}
