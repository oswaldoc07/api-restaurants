package com.ecommerce.api.restaurants.persistence.repository.impl;


import com.ecommerce.api.restaurants.domain.dto.Order;
import com.ecommerce.api.restaurants.persistence.repository.IOrderRepository;
import com.ecommerce.api.restaurants.persistence.crud.OrdenCrudRepository;
import com.ecommerce.api.restaurants.persistence.entity.Orden;
import com.ecommerce.api.restaurants.persistence.entity.OrdenProducto;
import com.ecommerce.api.restaurants.persistence.mapper.OrderMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository implements IOrderRepository {

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
    public Optional<Order> getOrderById(int id) {
        return crudRepository.findById(id).map(orden -> mapper.toOrder(orden));

    }

    @Override
    public Optional<Order> getOrderByIdAndClient(int id,int clientId) {
        return crudRepository.findByIdAndIdCliente(id,clientId).map(orden -> mapper.toOrder(orden));

    }

    @Override
    public Optional<List<Order>> getAllByClientAndState(Integer clientId,String state) {
        if(state.equals("PRO")){
         return this.getAllByClientAndProcess(clientId);
        }else{
            Optional<List<Orden>>  entities = crudRepository.findByIdClienteAndEstado(clientId,state);
            return entities.map(orders -> mapper.toOrders(orders));
        }


    }

    public Optional<List<Order>> getAllByClientAndProcess(Integer clientId) {
        Optional<List<Orden>> entities = crudRepository.findByIdClienteAndProceso(clientId);
        return entities.map(orders -> mapper.toOrders(orders));
    }
    @Override
    public Optional<List<Order>> getAllByCommerceAndState(int commerceId, String state, LocalDateTime startDate,
                                                          LocalDateTime endDate) {
        Optional<List<Orden>> entities = crudRepository.getAllByCommerceAndState( commerceId,  state,  startDate,endDate);
        return entities.map(orders -> mapper.toOrders(orders));
    }

    @Override
    public Optional<Order> getOrderByIdAndCourier(int id,int courierId) {
        return crudRepository.findByIdAndMensajeroId(id,courierId).map(orden -> mapper.toOrder(orden));
    }

    @Override
    public Optional<List<Order>> getAllByCourierAndState(int courierId,String state,LocalDateTime startDate,
                                                         LocalDateTime endDate) {
        Optional<List<Orden>> entities = crudRepository.getAllByCourierAndState(courierId,state, startDate,endDate);
        return entities.map(orders -> mapper.toOrders(orders));
    }





    @Override
    public Optional<Order> save(Order order) {
        try{
            Orden entity = mapper.toOrden(order);
            entity.getOrdenProductos().forEach(ordenProducto -> ordenProducto.setOrden(entity));
            return Optional.of(mapper.toOrder(crudRepository.save(entity)));
        }catch (Exception e){
            System.out.println(e);

        }
     return null;
    }

    @Override
    public Optional<Order> update(Order changes) {
      Orden entity=  crudRepository.findById(changes.getId()).map(orden->{
          List<OrdenProducto> ordenProductos=  orden.getOrdenProductos();
          Orden ordenToSave = mapper.toOrden(changes);
          ordenToSave.setOrdenProductos(ordenProductos);
          return ordenToSave;
        }).get();
        return Optional.of(mapper.toOrder(crudRepository.save(entity)));

        //return Optional.of(mapper.toOrder(crudRepository.save(mapper.toOrden(changes))));

    }

    @Override
    public Optional<Order> updateState(int orderId, String state) {
        return Optional.empty();
    }

    @Override
    public void delete(int id) {

    }
}
