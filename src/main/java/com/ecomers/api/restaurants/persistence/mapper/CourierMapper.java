package com.ecomers.api.restaurants.persistence.mapper;

import com.ecomers.api.restaurants.domain.dto.Client;
import com.ecomers.api.restaurants.domain.dto.Courier;
import com.ecomers.api.restaurants.persistence.entity.Cliente;
import com.ecomers.api.restaurants.persistence.entity.Mensajero;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourierMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "identificacion", target = "identification"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "telefono", target = "phoneNumber")
    })
    Courier toCourier(Mensajero entity);
    List<Courier> toCouriers(List<Mensajero> entities);

    @InheritInverseConfiguration
    @Mapping(target = "idComercio", ignore = true)
    Mensajero toMensajero(Courier dto);
}
