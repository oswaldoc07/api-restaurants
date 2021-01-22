package com.ecomers.api.restaurants.domain.repository;





import com.ecomers.api.restaurants.domain.dto.Order;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Order> getAll();
    Optional<List<Order>> getByClient(String clientId);
    Order save(Order purchase);
}
