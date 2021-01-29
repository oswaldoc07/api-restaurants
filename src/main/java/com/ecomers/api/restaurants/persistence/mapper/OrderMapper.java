package com.ecomers.api.restaurants.persistence.mapper;



import com.ecomers.api.restaurants.domain.dto.Order;
import com.ecomers.api.restaurants.persistence.entity.Orden;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OrderProductMapper.class})
public interface OrderMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "idComercio", target = "commerceId"),
            @Mapping(source = "fechaIngreso", target = "includeDate"),
            @Mapping(source = "fechaEstimada", target = "estimatedDate"),
            @Mapping(source = "fechaEntrega", target = "deliveredDate"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "precio", target = "price"),
            @Mapping(source = "costoEnvio", target = "shippingCost"),
            @Mapping(source = "productos", target = "items")
    })
    Order toOrder(Orden orden);
    List<Order> toOrders(List<Orden> ordenes);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "comercio", ignore = true)
    Orden toOrden(Order order);
}
