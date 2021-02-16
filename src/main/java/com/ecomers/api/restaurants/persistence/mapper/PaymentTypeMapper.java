package com.ecomers.api.restaurants.persistence.mapper;



import com.ecomers.api.restaurants.domain.dto.OrderProduct;
import com.ecomers.api.restaurants.domain.dto.PaymentType;
import com.ecomers.api.restaurants.persistence.entity.OrdenProducto;
import com.ecomers.api.restaurants.persistence.entity.TipoPago;
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
    PaymentType toPaymentType(TipoPago tipoPago);

    @InheritInverseConfiguration
    TipoPago toTipoPago(PaymentType paymentType);
}
