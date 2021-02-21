package com.ecomers.api.restaurants.persistence.dao;



import com.ecomers.api.restaurants.domain.dto.Product;
import com.ecomers.api.restaurants.domain.repository.ProductRepository;
import com.ecomers.api.restaurants.persistence.crud.ProductoCrudRepository;
import com.ecomers.api.restaurants.persistence.entity.Producto;
import com.ecomers.api.restaurants.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository crudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> entities = (List<Producto>) crudRepository.findAll();
        return mapper.toProducts(entities);
    }

    @Override
    public Optional<List<Product>> getByCommerceAndCategory(int commerce,int categoryId) {
        Optional<List<Producto>> entities = crudRepository.findByIdComercioAndIdCategoriaAndPromocionFalseOrderByNombreAsc(commerce,categoryId);
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
        return entities.map(prods -> mapper.toProducts(prods));
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
