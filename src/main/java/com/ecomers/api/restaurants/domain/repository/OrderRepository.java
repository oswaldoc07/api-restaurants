package com.ecomers.api.restaurants.domain.repository;



import com.ecomers.api.restaurants.domain.dto.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    List<Order> getAll();
    Optional<List<Order>>getAllByCommerceAndState(int commerceId,String state);
    Optional<List<Order>> getAllByUser(Integer userId);
    Optional<Order> save(Order dto);
    Optional<Order> update(Order dto);
    Optional<Order> updateState(int orderId, String state);
    void delete(int id);
}
