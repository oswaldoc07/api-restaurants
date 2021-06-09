package com.ecommerce.api.restaurants.domain.repository;

import java.util.List;
import java.util.Optional;

import com.ecommerce.api.restaurants.domain.dto.Commerce;


public interface CommerceRepository{

    Optional<List<Commerce>> getAll();
    Optional<List<Commerce>> getAllByCategory(int category);
    Optional<Commerce> getById(int id);
    Optional<Commerce> getByUrl(String url);
    Optional<Commerce> getByEmail(String email);
    Optional<Commerce>  save(Commerce dto);
    Optional<Commerce>  update(Commerce dto);
    void delete(int id);


}
