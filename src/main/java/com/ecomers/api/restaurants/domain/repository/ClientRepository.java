package com.ecomers.api.restaurants.domain.repository;



import com.ecomers.api.restaurants.domain.dto.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    Optional<List<Client>> getAll();
    Optional<Client> getClientById(int id);
    Optional<Client> getClientByEmail(String email);
    Optional<Client> getClientByPhone(String phone);
    Optional<Client>  save(Client dto);
    Optional<Client>  update(Client dto);
    void delete(int id);
}
