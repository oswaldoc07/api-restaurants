package com.ecomers.api.restaurants.web.controller;



import com.ecomers.api.restaurants.domain.dto.Order;
import com.ecomers.api.restaurants.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getByUser(@PathVariable("userId") Integer userId) {
        return service.getAllByUser(userId).map(
                orders -> new ResponseEntity<>(orders, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/commerce/{commerceId}/state/{state}")
    public ResponseEntity<List<Order>> getByCommerceAndState(
            @PathVariable("commerceId") Integer commerceId,
            @PathVariable("userId") String state) {
        return service.getAllByCommerceAndState(commerceId,state).map(
                orders -> new ResponseEntity<>(orders, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Order> save(@RequestBody Order purchase) {
        return null;//new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}

