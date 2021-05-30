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

    @Autowired
    private CourierService courierService;

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

            return orderSaved;
        }).get();
        return Optional.of(order);
    }

    public Optional<Order>  update(Order dto) {
        Order order= repository.update(dto).map(orderUpdated->{

            return orderUpdated;
        }).get();
        return Optional.of(order);
    }
    private void sentMessage(Order order){
        String number =null;
        String text=null;
        if ("ING".equals(order.getState())){
            number= this.clientService.getClientById(order.getClient().getId()).get().getPhoneNumber();
            text = this.parameterRepository.findByCode("API.MESSAGE.TEXT.CLIENT.ING").get().getValor()+order.getId();

        }else if ("RUT".equals(order.getState())){
            number= this.courierService.getCourierById(order.getClient().getId()).get().getPhoneNumber();
            text = this.parameterRepository.findByCode("API.MESSAGE.TEXT.CURIER").get().getValor()+order.getId();

        }else if ("RUT".equals(order.getState())){
            number= this.clientService.getClientById(order.getClient().getId()).get().getPhoneNumber();
            text = this.parameterRepository.findByCode("API.MESSAGE.TEXT.CLIENT.REC").get().getValor()+order.getId();
        }else{
            return;
        }

        Message message = new Message();
        message.setNumber(number);
        message.setMessage(text);
        this.messageService.sentMessage(message);
    }

}
