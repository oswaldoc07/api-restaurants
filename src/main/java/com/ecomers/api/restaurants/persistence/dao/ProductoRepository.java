package com.ecomers.api.restaurants.persistence.dao;



import com.ecomers.api.restaurants.domain.dto.Product;
import com.ecomers.api.restaurants.domain.repository.ProductRepository;
import com.ecomers.api.restaurants.persistence.crud.ProductoCrudRepository;
import com.ecomers.api.restaurants.persistence.entity.Producto;
import com.ecomers.api.restaurants.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCommerceAndCategory(int commerce,int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdComercioAndIdCategoriaAndPromocionFalseOrderByNombreAsc(commerce,categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    public Optional<List<Product>> getByCommercePromotions(int commerce) {
        List<Producto> productos = productoCrudRepository.findByIdComercioAndPromocionTrueOrderByNombreAsc(commerce);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    public Product update(Product changes){
         Product product=  productoCrudRepository.findById(changes.getId()).map(producto -> mapper.toProduct(producto)).get();
         product.setName(changes.getName());
         product.setPrice(changes.getPrice());
         product.setDescription(changes.getDescription());
         //product.setImage(changes.getImage());
         product.setPromotion(changes.isPromotion());
         product.setCategoryId(changes.getCategoryId());
         Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }
    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
