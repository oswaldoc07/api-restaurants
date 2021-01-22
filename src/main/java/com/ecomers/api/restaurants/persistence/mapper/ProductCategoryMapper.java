package com.ecomers.api.restaurants.persistence.mapper;



import com.ecomers.api.restaurants.domain.dto.Product;
import com.ecomers.api.restaurants.domain.dto.ProductCategory;
import com.ecomers.api.restaurants.persistence.entity.CategoriaProducto;
import com.ecomers.api.restaurants.persistence.entity.Producto;
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
    CategoriaProducto toCategoria(ProductCategory category);
}
