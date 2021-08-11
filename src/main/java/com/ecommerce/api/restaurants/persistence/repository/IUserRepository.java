package com.ecommerce.api.restaurants.persistence.repository;

import java.util.List;
import java.util.Optional;

import com.ecommerce.api.restaurants.domain.dto.User;

public interface IUserRepository {

    List<User> getAll();
    Optional<User> getById(int id);
    Optional<User> getByEmail(String email);
    Optional<User> getByPhone(String phone);
    Optional<User>  save(User dto);
    Optional<User>  update(User dto);
    void delete(int id);
}

