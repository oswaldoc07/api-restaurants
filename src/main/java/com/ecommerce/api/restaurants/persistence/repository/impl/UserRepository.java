package com.ecommerce.api.restaurants.persistence.repository.impl;


import com.ecommerce.api.restaurants.persistence.repository.IUserRepository;

import com.ecommerce.api.restaurants.persistence.crud.UsuarioCrudRepository;
import com.ecommerce.api.restaurants.persistence.mapper.UserMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import com.ecommerce.api.restaurants.domain.dto.User;

@Repository
public class UserRepository implements IUserRepository {

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
