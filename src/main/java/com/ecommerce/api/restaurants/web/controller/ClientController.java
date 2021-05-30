package com.ecommerce.api.restaurants.web.controller;

import com.ecommerce.api.restaurants.domain.dto.Client;
import com.ecommerce.api.restaurants.domain.service.ClientService;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.api.restaurants.domain.dto.User;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {


    @Autowired
    private ClientService service;

    //......................................................................................
    @ApiOperation("Get all clients")
    @GetMapping()
    public ResponseEntity<List<Client>> getAll() {
        return service.getAll()
                .map(clients -> new ResponseEntity<>(clients, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    //......................................................................................
    @ApiOperation("Search a user with an ID")
    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "client not found"),
    })
    public ResponseEntity<Client> getById(@ApiParam(value = "The id of the client", required = true, example = "7")
                                              @PathVariable("id") int userId) {
        return service.getClientById(userId)
                .map(client ->  new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{email}/{phone}")
    public ResponseEntity<Client> getClientByEmailOrPhone(@PathVariable("email") String email, @PathVariable("phone") String phone ) {
        return service.getClientByEmailOrPhone(email,phone)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));


    }

    //......................................................................................
    @PostMapping()
    public ResponseEntity<Client> save(@RequestBody Client dto) {
        return service.save(dto)
                .map(client ->  new ResponseEntity<>(client, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    //......................................................................................
    @PatchMapping()
    public ResponseEntity<Client> update(@RequestBody Client changes) {
        return service.update(changes)
                .map(client ->  new ResponseEntity<>(client, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    //......................................................................................
    @DeleteMapping("/{id}")
    public ResponseEntity<Client> delete(@PathVariable("id") int id) {
        if (service.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
