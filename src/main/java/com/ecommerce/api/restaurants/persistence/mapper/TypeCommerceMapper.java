package com.ecommerce.api.restaurants.persistence.mapper;

import com.ecommerce.api.restaurants.domain.dto.ProductCategory;
import com.ecommerce.api.restaurants.domain.dto.TypeCommerce;
import com.ecommerce.api.restaurants.persistence.entity.CategoriaProducto;
import com.ecommerce.api.restaurants.persistence.entity.TipoComercio;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeCommerceMapper {
    @Mappings({
            @Mapping(source = "idTipo", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "imagen", target = "image")
    })
    TypeCommerce toTypeCommerce(TipoComercio entity);
    List<TypeCommerce> toTypesCommerces(List<TipoComercio> entities);

    @InheritInverseConfiguration
    TipoComercio toTipoComercio(TypeCommerce dto);
}