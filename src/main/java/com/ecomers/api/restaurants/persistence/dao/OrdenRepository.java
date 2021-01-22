package com.ecomers.api.restaurants.persistence.dao;

import com.ecomers.api.restaurants.domain.dto.Order;
import com.ecomers.api.restaurants.domain.repository.PurchaseRepository;
import com.ecomers.api.restaurants.persistence.crud.OrdenCrudRepository;
import com.ecomers.api.restaurants.persistence.entity.Orden;
import com.ecomers.api.restaurants.persistence.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrdenRepository implements PurchaseRepository {
    @Autowired
    private OrdenCrudRepository ordenCrudRepository;

    @Autowired
    private OrderMapper mapper;

    @Override
    public List<Order> getAll() {

        return mapper.toOrders((List<Orden>) ordenCrudRepository.findAll());
    }

    @Override
    public Optional<List<Order>> getByClient(String userId) {
        return ordenCrudRepository.findByIdUsuario(userId)
                .map(ordenes -> mapper.toOrders(ordenes));
    }

    @Override
    public Order save(Order order) {
        Orden orden = mapper.toOrden(order);
        orden.getProductos().forEach(producto -> producto.setOrden(orden));
        return mapper.toOrder(ordenCrudRepository.save(orden));
    }
}
