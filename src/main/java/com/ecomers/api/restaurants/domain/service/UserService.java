package com.ecomers.api.restaurants.domain.service;

import com.ecomers.api.restaurants.domain.dto.User;
import com.ecomers.api.restaurants.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.getAll();
    }

    public Optional<User> getUserById(int userId) {
        return repository.getUserById(userId);
    }

    public Optional<User> getUserByEmailOrPhone(String email,String phone) {
        Optional<User> user = repository.getUserByEmail(email);
        if(user.isPresent()){
            return  user;
        }else {
         return repository.getUserByPhone(phone);
        }


    }

    public Optional<User>  save(User user) {
        return repository.save(user);
    }

    public Optional<User>  update(User user) {
        return repository.update(user);
    }
    public boolean delete(int productId) {
        return getUserById(productId).map(product -> {
            repository.delete(productId);
            return true;
        }).orElse(false);
    }

}
