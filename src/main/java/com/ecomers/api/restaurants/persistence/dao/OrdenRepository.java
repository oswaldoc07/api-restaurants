package com.ecomers.api.restaurants.persistence.dao;

import com.ecomers.api.restaurants.domain.dto.Order;
import com.ecomers.api.restaurants.domain.repository.OrderRepository;
import com.ecomers.api.restaurants.persistence.crud.OrdenCrudRepository;
import com.ecomers.api.restaurants.persistence.entity.Orden;
import com.ecomers.api.restaurants.persistence.entity.Producto;
import com.ecomers.api.restaurants.persistence.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class OrdenRepository implements OrderRepository {

    @Autowired
    private OrdenCrudRepository crudRepository;

    @Autowired
    private OrderMapper mapper;

    @Override
    public List<Order> getAll() {
        List<Orden> entities = (List<Orden>) crudRepository.findAll();
        return mapper.toOrders(entities);

    }
    @Override
    public Optional<List<Order>> getAllByCommerceAndState(int commerceId,String state) {
        Optional<List<Orden>> entities = crudRepository.findByIdComercioAndEstado(commerceId,state);
        return entities.map(orders -> mapper.toOrders(orders));
    }

    public Optional<List<Order>> getAllTodayByCommerceAndState(int commerceId, String state) {
        Date date = new Date();
        Optional<List<Orden>> entities = crudRepository.findByIdComercioAndEstado(commerceId,state);
        return entities.map(orders -> mapper.toOrders(orders));
    }



    @Override
    public Optional<List<Order>> getAllByUser(Integer userId) {
        Optional<List<Orden>> entities = crudRepository.findByIdCliente(userId);
        return entities.map(orders -> mapper.toOrders(orders));
    }

    @Override
    public Optional<Order> save(Order order) {
        Orden entity = mapper.toOrden(order);
        entity.getProductos().forEach(producto -> producto.setOrden(entity));
        return Optional.of(mapper.toOrder(crudRepository.save(entity)));
    }

    @Override
    public Optional<Order> update(Order dto) {
        return Optional.empty();
    }

    @Override
    public Optional<Order> updateState(int orderId, String state) {
        return Optional.empty();
    }

    @Override
    public void delete(int id) {

    }
}
