package com.ecomers.api.restaurants.persistence.mapper;



import com.ecomers.api.restaurants.domain.dto.OrderProduct;
import com.ecomers.api.restaurants.domain.dto.PaymentMethod;
import com.ecomers.api.restaurants.persistence.entity.ComercioTipoPago;
import com.ecomers.api.restaurants.persistence.entity.OrdenProducto;
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
