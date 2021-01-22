package com.ecomers.api.restaurants.domain.service;


import com.ecomers.api.restaurants.domain.dto.Order;
import com.ecomers.api.restaurants.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Order> getAll() {
        return purchaseRepository.getAll();
    }
    public Optional<List<Order>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }
    public Order save(Order purchase) {
        return purchaseRepository.save(purchase);
    }
}
