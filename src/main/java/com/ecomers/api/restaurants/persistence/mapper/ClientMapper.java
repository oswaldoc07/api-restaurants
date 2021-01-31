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
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "usuario.idUsuario", target = "userId"),
            @Mapping(source = "usuario.nombre", target = "displayName"),
            @Mapping(source = "usuario.correo", target = "email"),
            @Mapping(source = "usuario.celular", target = "phoneNumber"),
            @Mapping(source = "usuario.imagen", target = "photoURL"),
            @Mapping(source = "usuario.idRol", target = "role")
    })
    Client toClient(Cliente entity);
    List<Client> toClients(List<Cliente> entities);

    @InheritInverseConfiguration
    @Mapping(target = "ordenes", ignore = true)
    //@Mapping(target = "usuario", ignore = true)
    Cliente toCliente(Client dto);
}
