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
            @Mapping(source = "idComercio", target = "id"),
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "nombre", target = "displayName"),
            @Mapping(source = "geolocalizacion", target = "geolocalization"),
            @Mapping(source = "url", target = "url"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "correo", target = "email"),
            @Mapping(source = "celular", target = "phoneNumber"),
            @Mapping(source = "imagen", target = "photoURL"),
            @Mapping(source = "idRol", target = "role")
    })
    Commerce toCommerce(Comercio entity);
    List<Commerce> toCommerces(List<Comercio> entities);

    @InheritInverseConfiguration
    @Mapping(target = "ordenes", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "tipo_comercio", ignore = true)
    //@Mapping(target = "rol", ignore = true)
    Comercio toComercio(Commerce commerce);
}

