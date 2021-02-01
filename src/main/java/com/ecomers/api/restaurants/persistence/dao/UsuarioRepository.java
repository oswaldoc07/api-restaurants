package com.ecomers.api.restaurants.persistence.dao;


import com.ecomers.api.restaurants.domain.dto.User;
import com.ecomers.api.restaurants.domain.repository.UserRepository;
import com.ecomers.api.restaurants.persistence.crud.UsuarioCrudRepository;
import com.ecomers.api.restaurants.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository crudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> getById(int id) {
        return crudRepository.findById(id).map(user -> mapper.toUser(user));

    }

    @Override
    public Optional<User> getByEmail(String email) {
        return crudRepository.findByCorreo(email).map(user -> mapper.toUser(user));
    }

    @Override
    public Optional<User> getByPhone(String phone) {
        return crudRepository.findByCelular(phone).map(user -> mapper.toUser(user));
    }

    @Override
    public Optional<User> save(User dto) {
        return Optional.empty();
    }

    @Override
    public Optional<User> update(User dto) {
        return Optional.empty();
    }

    @Override
    public void delete(int id) {

    }
}
