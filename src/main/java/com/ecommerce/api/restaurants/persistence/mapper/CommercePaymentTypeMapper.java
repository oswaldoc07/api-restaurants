package com.ecommerce.api.restaurants.persistence.mapper;



import com.ecommerce.api.restaurants.domain.dto.PaymentMethod;
import com.ecommerce.api.restaurants.persistence.entity.ComercioTipoPago;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CommercePaymentTypeMapper {

    @Mappings({
            @Mapping(source = "id.idTipo", target = "id"),
            @Mapping(source = "tipoPago.nombre", target = "name")



    })
    PaymentMethod toPaymentMethod(ComercioTipoPago comercioTipoPago);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "comercio", ignore = true)
    })
    ComercioTipoPago toComercioTipoPago(PaymentMethod PaymentMethod);
}
