package com.ecomers.api.restaurants.domain.service;

import com.ecomers.api.restaurants.domain.dto.Client;
import com.ecomers.api.restaurants.domain.dto.Message;
import com.ecomers.api.restaurants.domain.dto.Order;
import com.ecomers.api.restaurants.domain.repository.OrderRepository;
import com.ecomers.api.restaurants.domain.repository.ParameterRepository;
import com.ecomers.api.restaurants.persistence.entity.Orden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;


    @Autowired
    private ParameterRepository parameterRepository;

    @Autowired
    private MessageService messageService;

    @Autowired
    private ClientService clientService;

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

    public Optional<List<Order>> getAllByCourierAndState(Integer courierId, String state) {

        return repository.getAllByCourierAndState(courierId,state);
    }

    public Optional<List<Order>> getAllByUser(int userId) {
        return repository.getAllByUser(userId);
    }

    public Optional<Order>  save(Order dto) {
        Order order=  this.repository.save(dto).map(orderSaved->{
            Message message = new Message();
            String text = this.parameterRepository.findByCode("API.MESSAGE.TEXT.CLIENT").get().getValor();
            message.setMessage(text+orderSaved.getId());
            String number = this.clientService.getClientById(orderSaved.getClient().getId()).get().getPhoneNumber();
            message.setNumber(number);
            this.messageService.sentMessage(message);
            return orderSaved;
        }).get();
        return Optional.of(order);
    }

    public Optional<Order>  update(Order dto) {
        return repository.update(dto);
    }

}
