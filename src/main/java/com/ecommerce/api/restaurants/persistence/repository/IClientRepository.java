package com.ecommerce.api.restaurants.persistence.repository;



import java.util.List;
import java.util.Optional;

import com.ecommerce.api.restaurants.domain.dto.Client;

public interface IClientRepository {
    Optional<List<Client>> getAll();
    Optional<Client> getClientById(int id);
    Optional<Client> getClientByEmail(String email);
    Optional<Client> getClientByPhone(String phone);
    Optional<Client>  save(Client dto);
    Optional<Client>  update(Client dto);
    void delete(int id);
}
