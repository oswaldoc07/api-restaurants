package com.ecomers.api.restaurants.persistence.dao;


import com.ecomers.api.restaurants.domain.dto.Client;
import com.ecomers.api.restaurants.domain.dto.User;
import com.ecomers.api.restaurants.domain.repository.ClientRepository;
import com.ecomers.api.restaurants.persistence.crud.ClienteCrudRepository;
import com.ecomers.api.restaurants.persistence.entity.Cliente;
import com.ecomers.api.restaurants.persistence.entity.Usuario;
import com.ecomers.api.restaurants.persistence.mapper.ClientMapper;
import com.ecomers.api.restaurants.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {

    @Autowired
    private ClienteCrudRepository crudRepository;

    @Autowired
    private ClientMapper mapper;

    @Override
    public  Optional<List<Client>> getAll() {
        List<Cliente> entities = (List<Cliente>) crudRepository.findAll();
        return Optional.of(mapper.toClients(entities));
    }

    @Override
    public Optional<Client> getClientById(int id) {
        return crudRepository.findById(id).map(cliente -> mapper.toClient(cliente));

    }

    @Override
    public Optional<Client> getClientByEmail(String email) {
       return crudRepository.findByUsuarioCorreo(email).map(cliente -> mapper.toClient(cliente));
    }

    @Override
    public Optional<Client> getClientByPhone(String phone) {
        return crudRepository.findByUsuarioCelular(phone).map(cliente -> mapper.toClient(cliente));
    }

    @Override
    public  Optional<Client> save(Client dto) {
        Cliente entity = mapper.toCliente(dto);
        entity.getUsuario().setActivo(true);
        return Optional.of(mapper.toClient(crudRepository.save(entity)));
    }

    @Override
    public Optional<Client>  update(Client changes) {
        Cliente entity=  crudRepository.findById(changes.getId()).map(cliente->{
            cliente.getUsuario().setCorreo(changes.getEmail());
            cliente.getUsuario().setCelular(changes.getPhoneNumber());
            return cliente;
        }).get();


        return Optional.of(mapper.toClient(crudRepository.save(entity)));
    }

    @Override
    public void delete(int id) {
        this.crudRepository.deleteById(id);
    }
}
