package com.ecomers.api.restaurants.persistence.mapper;

import com.ecomers.api.restaurants.domain.dto.Commerce;
import com.ecomers.api.restaurants.domain.dto.Product;
import com.ecomers.api.restaurants.persistence.entity.Comercio;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommerceMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "tipo_comercio", target = "type"),
            @Mapping(source = "geolocalizacion", target = "geolocalization"),
            @Mapping(source = "url", target = "url"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "imagen", target = "image")
    })
    Commerce toCommerce(Comercio entity);
    List<Commerce> toCommerces(List<Comercio> entities);

    @InheritInverseConfiguration
//    @Mapping(target = "codigoBarras", ignore = true)
    Comercio toComercio(Commerce commerce);
}

