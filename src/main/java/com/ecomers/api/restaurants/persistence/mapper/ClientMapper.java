package com.ecomers.api.restaurants.persistence.mapper;

import com.ecomers.api.restaurants.domain.dto.Client;
import com.ecomers.api.restaurants.domain.dto.User;
import com.ecomers.api.restaurants.persistence.entity.Cliente;
import com.ecomers.api.restaurants.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ClientMapper {
    @Mappings({
            @Mapping(source = "idCliente", target = "id"),
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "nombre", target = "displayName"),
            @Mapping(source = "correo", target = "email"),
            @Mapping(source = "celular", target = "phoneNumber"),
            @Mapping(source = "imagen", target = "photoURL"),
            @Mapping(source = "idRol", target = "role")
    })
    Client toClient(Cliente entity);
    List<Client> toClients(List<Cliente> entities);

    @InheritInverseConfiguration
    @Mapping(target = "ordenes", ignore = true)
    @Mapping(target = "activo", ignore = true)
   // @Mapping(target = "rol", ignore = true)
    Cliente toCliente(Client dto);
}
