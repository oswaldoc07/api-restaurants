package com.ecommerce.api.restaurants.domain.service;

import com.ecommerce.api.restaurants.domain.dto.Message;
import com.ecommerce.api.restaurants.domain.dto.Order;
import com.ecommerce.api.restaurants.domain.repository.OrderRepository;
import com.ecommerce.api.restaurants.domain.repository.ParameterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Optional<Order> getOrderByIdAndCourier(int id,int courierId) {
        return repository.getOrderByIdAndCourier(id, courierId);
    }
    public Optional<List<Order>> getAllByCommerceAndState(int commerceId, String state, LocalDateTime startDate,
                                                          LocalDateTime endDate) {

        return repository.getAllByCommerceAndState(commerceId,state,startDate,endDate);
    }

    public Optional<List<Order>> getAllByCourierAndState(Integer courierId, String state, LocalDateTime startDate,
                                                         LocalDateTime endDate) {

        return repository.getAllByCourierAndState(courierId,state,startDate,endDate);
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
