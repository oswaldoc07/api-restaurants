package com.ecomers.api.restaurants.domain.service;

import com.ecomers.api.restaurants.domain.dto.Client;
import com.ecomers.api.restaurants.domain.dto.Order;
import com.ecomers.api.restaurants.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> getAll() {

        return repository.getAll();
    }

    public Optional<Order> getOrderById(int id) {
        return repository.getOrderById(id);
    }

    public Optional<Order> getOrderByIdAndClient(int id,int clientId) {
        return repository.getOrderByIdAndClient(id, clientId);
    }
    public Optional<List<Order>> getAllByCommerceAndState(Integer commerceId, String state) {

        return repository.getAllByCommerceAndState(commerceId,state);
    }

    public Optional<List<Order>> getAllByUser(int userId) {
        return repository.getAllByUser(userId);
    }

    public Optional<Order>  save(Order dto) {
        return repository.save(dto);
    }

    public Optional<Order>  update(Order dto) {
        return repository.update(dto);
    }

}
