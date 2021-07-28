package com.ecommerce.api.restaurants.persistence.mapper;

import com.ecommerce.api.restaurants.domain.dto.SettingCommerce;
import com.ecommerce.api.restaurants.persistence.entity.ConfiguracionComercio;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SettingCommerceMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "idComercio", target = "idComercio"),
            @Mapping(source = "enviosms", target = "enviosms"),
            @Mapping(source = "radiocobertura", target = "radiocobertura")
    })
    SettingCommerce toSettingCommerce(ConfiguracionComercio entity);
    List<SettingCommerce> toSettingCommerces(List<ConfiguracionComercio> entities);

   
    @InheritInverseConfiguration
    @Mapping(target = "comercio", ignore = true)

    ConfiguracionComercio toConfiguracionComercio(SettingCommerce settingCommerce);
}
