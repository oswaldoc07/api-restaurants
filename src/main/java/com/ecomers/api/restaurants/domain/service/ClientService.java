package com.ecomers.api.restaurants.domain.service;

import com.ecomers.api.restaurants.domain.dto.Client;
import com.ecomers.api.restaurants.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public Optional<List<Client>> getAll() {
        return repository.getAll();
    }

    public Optional<Client> getClientById(int id) {
        return repository.getClientById(id);
    }

    public Optional<Client> getClientByEmailOrPhone(String email,String phone) {
        Optional<Client> dto = repository.getClientByEmail(email);
        if(dto.isPresent()){
            return  dto;
        }else {
         return repository.getClientByPhone(phone);
        }


    }

    public Optional<Client>  save(Client dto) {
        return repository.save(dto);
    }

    public Optional<Client>  update(Client dto) {
        return repository.update(dto);
    }
    public boolean delete(int productId) {
        return getClientById(productId).map(product -> {
            repository.delete(productId);
            return true;
        }).orElse(false);
    }

}
