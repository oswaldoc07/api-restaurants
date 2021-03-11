package com.ecomers.api.restaurants.domain.service;

import com.ecomers.api.restaurants.domain.dto.Client;
import com.ecomers.api.restaurants.domain.dto.Commerce;
import com.ecomers.api.restaurants.domain.dto.Courier;
import com.ecomers.api.restaurants.domain.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourierService {

    @Autowired
    private CourierRepository repository;

    public Optional<List<Courier>> getAll() {
        return repository.getAll();
    }

    public Optional<List<Courier>> getAllByCommerce(int commerceId) {
        return repository.getAllByCommerce(commerceId);
    }

    public Optional<Courier> getCourierById(int id) {
        return repository.getCourierById(id);
    }

    public Optional<Courier> getByEmail(String email) {
        return repository.getByEmail(email);
    }

    public Optional<Courier>  save(Courier dto) {
        return repository.save(dto);
    }

    public Optional<Courier>  update(Courier dto) {
        return repository.update(dto);
    }
    public boolean delete(int id) {
        return getCourierById(id).map(product -> {
            repository.delete(id);
            return true;
        }).orElse(false);
    }

}
