package com.ecommerce.api.restaurants.persistence.mapper;


import com.ecommerce.api.restaurants.domain.dto.Product;
import com.ecommerce.api.restaurants.persistence.entity.Producto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductCategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "imagen", target = "image"),
            @Mapping(source = "imagen2", target = "image2"),
            @Mapping(source = "imagen3", target = "image3"),
            //@Mapping(source= "imagenes", target="images"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source= "promocion", target="promotion"),
            @Mapping(source= "idComercio", target="commerceId")
    })
    Product toProduct(Producto entity);
    List<Product> toProducts(List<Producto> entities);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product dto);
}
