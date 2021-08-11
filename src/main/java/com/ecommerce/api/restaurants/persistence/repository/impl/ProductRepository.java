package com.ecommerce.api.restaurants.persistence.repository.impl;



import com.ecommerce.api.restaurants.domain.dto.Product;
import com.ecommerce.api.restaurants.persistence.repository.IProductRepository;
import com.ecommerce.api.restaurants.persistence.crud.ProductoCrudRepository;
import com.ecommerce.api.restaurants.persistence.entity.Producto;
import com.ecommerce.api.restaurants.persistence.mapper.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {
    @Autowired
    private ProductoCrudRepository crudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public Optional<List<Product>> getAllByCommerce(int commerceId) {
        Optional<List<Producto>> entities = crudRepository.findByIdComercioOrderByNombreAsc(commerceId);
        //Stream<Producto> entitiesa = entities.get().stream();
        return entities.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<List<Product>> getByCommerceAndCategory(int commerce,int categoryId) {
        Optional<List<Producto>> entities = crudRepository.findByIdComercioAndIdCategoriaOrderByNombreAsc(commerce,categoryId);
        return entities.map(prods -> mapper.toProducts(prods));
        //return Optional.of(mapper.toProducts(productos));
    }

    public Optional<List<Product>> getByCommercePromotions(int commerce) {
        Optional<List<Producto>> entities = crudRepository.findByIdComercioAndPromocionTrueOrderByNombreAsc(commerce);
        return entities.map(prods -> mapper.toProducts(prods));
       // return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> entities = crudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return entities.flatMap(prods -> Optional.ofNullable(mapper.toProducts(prods)));
    }

    @Override
    public Optional<Product> getProduct(int id) {
       return crudRepository.findById(id).map(entity -> mapper.toProduct(entity));

    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(crudRepository.save(producto));
    }

    public Product update(Product changes){
         Producto entity=  crudRepository.findById(changes.getId()).get();
         //.map(producto -> mapper.toProduct(producto)).get();
        entity.setNombre(changes.getName());
        entity.setPrecioVenta(changes.getPrice());
        entity.setDescripcion(changes.getDescription());
         if(changes.getImage()!=null){
             entity.setImagen(changes.getImage());
         }
        if(changes.getImage2()!=null){
            entity.setImagen2(changes.getImage2());
        }
        if(changes.getImage3()!=null){
            entity.setImagen3(changes.getImage3());
        }

        entity.setPromocion(changes.isPromotion());
        entity.setIdCategoria(changes.getCategoryId());
         //Producto producto = mapper.toProducto(product);
        return mapper.toProduct(crudRepository.save(entity));
    }
    @Override
    public void delete(int id) {
        crudRepository.deleteById(id);
    }
}
