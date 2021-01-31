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
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "usuario.nombre", target = "displayName"),
            @Mapping(source = "usuario.correo", target = "email"),
            @Mapping(source = "usuario.celular", target = "phoneNumber"),
            @Mapping(source = "usuario.imagen", target = "photoURL"),
            @Mapping(source = "usuario.idRol", target = "role"),
            @Mapping(source = "geolocalizacion", target = "geolocalization"),
            @Mapping(source = "url", target = "url"),
            @Mapping(source = "descripcion", target = "description")


    })
    Commerce toCommerce(Comercio entity);
    List<Commerce> toCommerces(List<Comercio> entities);

    @InheritInverseConfiguration
    @Mapping(target = "ordenes", ignore = true)
    @Mapping(target = "tipo_comercio", ignore = true)
    @Mapping(target = "usuario", ignore = true)

    Comercio toComercio(Commerce commerce);
}

