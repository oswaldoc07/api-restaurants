package com.ecommerce.api.restaurants.persistence.mapper;



import com.ecommerce.api.restaurants.domain.dto.OrderProduct;
import com.ecommerce.api.restaurants.persistence.entity.OrdenProducto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface OrderProductMapper {

    @Mappings({

            @Mapping(source = "id.idProducto", target = "product.id"),
            @Mapping(source = "producto.nombre", target = "product.name"),
            @Mapping(source = "producto.imagen", target = "product.image"),
            @Mapping(source= "producto.promocion", target="product.promotion"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "subtotal", target = "subtotal")

    })
    OrderProduct toOrderProduct(OrdenProducto ordenProducto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "orden", ignore = true),
            @Mapping(target = "id.idOrden", ignore = true),
            @Mapping(target = "producto", ignore = true)
    })
    OrdenProducto toOrdenProducto(OrderProduct orderProduct);
}
