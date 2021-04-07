package com.ecomers.api.restaurants.domain.repository;



import com.ecomers.api.restaurants.domain.dto.Client;
import com.ecomers.api.restaurants.domain.dto.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    List<Order> getAll();
    Optional<Order> getOrderById(int id);
    Optional<Order> getOrderByIdAndClient(int id,int clientId);
    Optional<Order> getOrderByIdAndCourier(int id,int courierId);
    Optional<List<Order>>getAllByCommerceAndState(int commerceId, String state, LocalDateTime startDate,
                                                  LocalDateTime endDate);
    Optional<List<Order>>getAllByCourierAndState(int courierId,String state,LocalDateTime startDate,
                                                 LocalDateTime endDate);
    Optional<List<Order>> getAllByUser(Integer userId);
    Optional<Order> save(Order dto);
    Optional<Order> update(Order dto);
    Optional<Order> updateState(int orderId, String state);
    void delete(int id);
}
