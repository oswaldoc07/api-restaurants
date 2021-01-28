package com.ecomers.api.restaurants.domain.service;

import com.ecomers.api.restaurants.domain.dto.User;
import com.ecomers.api.restaurants.domain.repository.ClientRepository;
import com.ecomers.api.restaurants.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository  repository;

    public Optional<User> getById(int id) {
        return repository.getById(id);
    }

    public Optional<User> getByEmailOrPhone(String email,String phone) {
        Optional<User> dto = repository.getByEmail(email);
        if(dto.isPresent()){
            return  dto;
        }else {
            return repository.getByPhone(phone);
        }


    }


}
