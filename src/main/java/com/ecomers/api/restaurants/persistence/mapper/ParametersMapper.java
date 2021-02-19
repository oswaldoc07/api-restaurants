package com.ecomers.api.restaurants.persistence.mapper;


import com.ecomers.api.restaurants.domain.dto.Parameter;
import com.ecomers.api.restaurants.persistence.entity.Parametro;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParametersMapper {
    @Mappings({
            @Mapping(source = "idParametro", target = "id"),
            @Mapping(source = "codigo", target = "code"),
            @Mapping(source = "valor", target = "valor"),
            @Mapping(source = "descripcion", target = "description"),

    })
    Parameter toParameter(Parametro entity);
    List<Parameter> toParameters(List<Parametro> entities);

    @InheritInverseConfiguration
    Parametro toParametro(Parameter dto);
}