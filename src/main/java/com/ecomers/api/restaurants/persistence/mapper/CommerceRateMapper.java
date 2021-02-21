package com.ecomers.api.restaurants.persistence.mapper;

import com.ecomers.api.restaurants.domain.dto.CommerceRate;
import com.ecomers.api.restaurants.domain.dto.Courier;
import com.ecomers.api.restaurants.persistence.entity.Mensajero;
import com.ecomers.api.restaurants.persistence.entity.TarifaComercio;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommerceRateMapper {
    @Mappings({
            @Mapping(source = "idTarifa", target = "id"),
            @Mapping(source = "idComercio", target = "commerceId"),
            @Mapping(source = "distancia", target = "distance"),
            @Mapping(source = "tarifa", target = "rate")
    })
    CommerceRate toCommerceRate(TarifaComercio entity);
    List<CommerceRate> toCommerceRates(List<TarifaComercio> entities);

    @InheritInverseConfiguration
    TarifaComercio toTarifaComercio(CommerceRate dto);
}
