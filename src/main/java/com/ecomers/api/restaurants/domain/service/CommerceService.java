package com.ecomers.api.restaurants.domain.service;

import com.ecomers.api.restaurants.domain.dto.Client;
import com.ecomers.api.restaurants.domain.dto.Commerce;
import com.ecomers.api.restaurants.domain.repository.ClientRepository;
import com.ecomers.api.restaurants.domain.repository.CommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommerceService {


    @Autowired
    private CommerceRepository repository;

    public Optional<List<Commerce>> getAll() {
        return repository.getAll();
    }

    public Optional<Commerce> getById(int id) {
        return repository.getById(id);
    }

    public Optional<Commerce> getByEmail(String email) {
            return repository.getByEmail(email);
    }

    public Optional<Commerce> getByUrl(String url) {
        return repository.getByUrl(url);
    }


    public Optional<Commerce>  save(Commerce dto) {
        return repository.save(dto);
    }

    public Optional<Commerce>  update(Commerce dto) {
        return repository.update(dto);
    }
    public boolean delete(int commerceId) {
        return getById(commerceId).map(commerce -> {
            repository.delete(commerceId);
            return true;
        }).orElse(false);
    }
}
