package com.ecomers.api.restaurants.persistence.mapper;



import com.ecomers.api.restaurants.domain.dto.Order;
import com.ecomers.api.restaurants.persistence.entity.Orden;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OrderProductMapper.class,ClientMapper.class, PaymentTypeMapper.class})
public interface OrderMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "idCliente", target = "client.id"),
            @Mapping(source = "cliente.usuario.nombre", target = "client.displayName"),
            @Mapping(source = "cliente.usuario.correo", target = "client.email"),
            @Mapping(source = "cliente.usuario.celular", target = "client.phoneNumber"),
            @Mapping(source = "idComercio", target = "commerceId"),
            @Mapping(source = "fechaIngreso", target = "includedDate"),
            @Mapping(source = "fechaEstimada", target = "estimatedDate"),
            @Mapping(source = "fechaEntrega", target = "deliveredDate"),
            @Mapping(source = "tipoPago.id", target = "paymentMethod.id"),
            @Mapping(source = "tipoPago.nombre", target = "paymentMethod.name"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "precio", target = "price"),
            @Mapping(source = "costoEnvio", target = "shippingCost"),
            @Mapping(source = "ordenProductos", target = "cartItem"),
            @Mapping(source = "motivoRechazo", target = "desRejected"),
            @Mapping(source = "ubicacionGPS", target = "ubicationGPS"),
            @Mapping(source = "idMensajero", target = "idCourier"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "montoEfectivo", target = "cashAmount"),
            @Mapping(source = "tiempoEnvio", target = "deliveryTime")

    })
    Order toOrder(Orden orden);
    List<Order> toOrders(List<Orden> ordenes);

    @InheritInverseConfiguration
    @Mapping(target = "comercio", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "tipoPago.ordenes", ignore = true)
    Orden toOrden(Order order);
}
