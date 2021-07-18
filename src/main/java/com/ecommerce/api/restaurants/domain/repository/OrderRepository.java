package com.ecommerce.api.restaurants.domain.repository;



import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.ecommerce.api.restaurants.domain.dto.Order;

public interface OrderRepository {

    List<Order> getAll();
    Optional<Order> getOrderById(int id);
    Optional<Order> getOrderByIdAndClient(int id,int clientId);
    Optional<List<Order>> getAllByClientAndState(Integer cliendId, String state);

    Optional<Order> getOrderByIdAndCourier(int id,int courierId);
    Optional<List<Order>>getAllByCourierAndState(int courierId,String state,LocalDateTime startDate,
                                                 LocalDateTime endDate);

    Optional<List<Order>>getAllByCommerceAndState(int commerceId, String state, LocalDateTime startDate,
                                                  LocalDateTime endDate);

    Optional<Order> save(Order dto);
    Optional<Order> update(Order dto);
    Optional<Order> updateState(int orderId, String state);
    void delete(int id);
}
