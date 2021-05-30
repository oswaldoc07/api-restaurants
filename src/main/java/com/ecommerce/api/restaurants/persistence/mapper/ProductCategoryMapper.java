package com.ecommerce.api.restaurants.persistence.mapper;



import com.ecommerce.api.restaurants.domain.dto.ProductCategory;
import com.ecommerce.api.restaurants.persistence.entity.CategoriaProducto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "estado", target = "active"),
    })
    ProductCategory toCategory(CategoriaProducto categoriaProducto);
    List<ProductCategory> toCategories(List<CategoriaProducto> entities);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    @Mapping(target = "comercios", ignore = true)
    CategoriaProducto toCategoria(ProductCategory category);
}
