package com.ecomers.api.restaurants.persistence.mapper;

import com.ecomers.api.restaurants.domain.dto.Product;
import com.ecomers.api.restaurants.domain.dto.User;
import com.ecomers.api.restaurants.persistence.entity.Producto;
import com.ecomers.api.restaurants.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface UserMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "displayName"),
            @Mapping(source = "correoElectronico", target = "email"),
            @Mapping(source = "celular", target = "phoneNumber"),
            @Mapping(source = "direccion", target = "direction"),
            @Mapping(source = "comercioId", target = "commerceId")
    })
    User toUser(Usuario entity);
    List<User> toUsers(List<Usuario> entities);

    @InheritInverseConfiguration
    @Mapping(target = "ordenes", ignore = true)
    Usuario toUsuario(User dto);
}
