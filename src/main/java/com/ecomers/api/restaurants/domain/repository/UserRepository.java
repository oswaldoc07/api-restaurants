package com.ecomers.api.restaurants.domain.repository;


import com.ecomers.api.restaurants.domain.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {


    List<User> getAll();
    Optional<User> getUserById(int id);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByPhone(String phone);
    Optional<User>  save(User dto);
    Optional<User>  update(User dto);
    void delete(int id);
}
