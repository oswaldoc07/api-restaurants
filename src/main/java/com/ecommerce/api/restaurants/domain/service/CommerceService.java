package com.ecommerce.api.restaurants.domain.service;

import com.ecommerce.api.restaurants.domain.dto.Commerce;
import com.ecommerce.api.restaurants.domain.dto.CommerceRate;
import com.ecommerce.api.restaurants.domain.repository.CommerceRateRepository;
import com.ecommerce.api.restaurants.domain.repository.CommerceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommerceService {


    @Autowired
    private CommerceRepository repository;

    @Autowired
    private CommerceRateRepository commerceRateRepository;


    public Optional<List<Commerce>> getAll() {
        return repository.getAll();
    }
    public Optional<List<Commerce>> getAllByCategory(int category) {
        return repository.getAllByCategory(category) ;
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

    public Optional<Integer> getRate(int commerceId, double distance){
   List<CommerceRate> rates=   commerceRateRepository.getAllByCommerce(commerceId).get();
   int rate =0;
   int size = rates.size();
   boolean found =false;
   for(int count=0; count <size; count++){
     if(distance<rates.get(count).getDistance()){
         rate = rates.get(count-1).getRate();
         found=true;
         break;
     }
   }
   if(!found){
       rate = rates.get(size-1).getRate();
   }

        return Optional.of(rate);
    }
}
