package com.ecommerce.api.restaurants.persistence.mapper;


import com.ecommerce.api.restaurants.domain.dto.User;
import com.ecommerce.api.restaurants.persistence.entity.Usuario;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "nombre", target = "displayName"),
            @Mapping(source = "correo", target = "email"),
            @Mapping(source = "celular", target = "phoneNumber"),
            @Mapping(source = "imagen", target = "photoURL"),
            @Mapping(source = "idRol", target = "role"),
            @Mapping(source = "activo", target = "active")

    })
    User toUser(Usuario entity);
    List<User> toUsers(List<Usuario> entities);

    @InheritInverseConfiguration
    @Mapping(target = "activo", ignore = true)
   // @Mapping(target = "rol", ignore = true)
    Usuario toUsuario(User dto);
}
