package com.ecomers.api.restaurants.web.controller;



import com.ecomers.api.restaurants.domain.dto.Client;
import com.ecomers.api.restaurants.domain.dto.Order;
import com.ecomers.api.restaurants.domain.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping()
    @ApiOperation("Get all orders")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Order>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }



    //......................................................................................
    @ApiOperation("Search a order by ID")
    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Order not found"),
    })
    public ResponseEntity<Order> getOrderById(@ApiParam(value = "The id of the id", required = true, example = "7")
                                                       @PathVariable("id") Integer id) {
        return service.getOrderById(id)
                .map(product ->  new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    //......................................................................................
    @ApiOperation("Search a order by ID and client")
    @GetMapping("/client/{id}/{clientId}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Order not found"),
    })
    public ResponseEntity<Order> getOrderByIdAndClient(@ApiParam(value = "The id of the order and client", required = true, example = "7,1")
                                                         @PathVariable("id") Integer id,
                                                     @PathVariable("clientId") Integer clientId) {
        return service.getOrderByIdAndClient(id,clientId)
                .map(product ->  new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/state/{userId}/{state}")
    @ApiOperation("Get all orders by user")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Order>> getAllByUserAndState(@PathVariable("userId") Integer userId,
                                                    @PathVariable("state") String state) {
        return service.getAllByUser(userId).map(
                orders -> new ResponseEntity<>(orders, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/commerce/state/{commerceId}/{state}")
    @ApiOperation("Get all orders by commerce and state")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Order>> getAllByCommerceAndState(
            @PathVariable("commerceId") Integer commerceId,
            @PathVariable("state") String state) {
        return service.getAllByCommerceAndState(commerceId,state).map(
                orders -> new ResponseEntity<>(orders, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/courier/state/{courierId}/{state}")
    @ApiOperation("Get all orders by courier and state")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Order>> getAllByCourierAndState(
            @PathVariable("courierId") Integer commerceId,
            @PathVariable("state") String state) {
        return service.getAllByCourierAndState(commerceId,state).map(
                orders -> new ResponseEntity<>(orders, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping()
    public ResponseEntity<Order> save(@RequestBody Order dto) {
        dto.setIncludedDate(LocalDateTime.now());
        return service.save(dto)
                .map(client ->  new ResponseEntity<>(client, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

    }


    //......................................................................................
    @PatchMapping()
    public ResponseEntity<Order> update(@RequestBody Order changes) {
        return service.update(changes)
                .map(client ->  new ResponseEntity<>(client, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}

