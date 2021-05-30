package com.ecommerce.api.restaurants.persistence.mapper;



import com.ecommerce.api.restaurants.domain.dto.PaymentMethod;
import com.ecommerce.api.restaurants.persistence.entity.TipoPago;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PaymentTypeMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "name")
    })
    PaymentMethod toPaymentMethod(TipoPago tipoPago);

    @InheritInverseConfiguration
    @Mapping(target = "ordenes", ignore = true)
    TipoPago toTipoPago(PaymentMethod paymentMethod);
}
