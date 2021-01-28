package com.ecomers.api.restaurants.domain.repository;

import com.ecomers.api.restaurants.domain.dto.Client;
import com.ecomers.api.restaurants.domain.dto.Commerce;
import com.ecomers.api.restaurants.domain.dto.Product;

import java.util.List;
import java.util.Optional;

public interface CommerceRepository{

    Optional<List<Commerce>> getAll();
    Optional<Commerce> getById(int id);
    Optional<Commerce> getByUrl(String url);
    Optional<Commerce> getByEmail(String email);
    Optional<Commerce>  save(Commerce dto);
    Optional<Commerce>  update(Commerce dto);
    void delete(int id);


}
