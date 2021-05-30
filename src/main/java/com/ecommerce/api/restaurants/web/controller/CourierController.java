package com.ecommerce.api.restaurants.web.controller;

import com.ecommerce.api.restaurants.domain.dto.Client;
import com.ecommerce.api.restaurants.domain.dto.Commerce;
import com.ecommerce.api.restaurants.domain.dto.Courier;
import com.ecommerce.api.restaurants.domain.service.ClientService;
import com.ecommerce.api.restaurants.domain.service.CourierService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/couriers")
public class CourierController {


    @Autowired
    private CourierService service;

    //......................................................................................
    @ApiOperation("Get all couriers")
    @GetMapping()
    public ResponseEntity<List<Courier>> getAll() {
        return service.getAll()
                .map(couriers -> new ResponseEntity<>(couriers, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //......................................................................................
    @ApiOperation("Get all couriers by commerce")
    @GetMapping("/commerce/{commerceId}")
    public ResponseEntity<List<Courier>> getAllByCommerce(@ApiParam(value = "The id commerce",
            required = true, example = "7") @PathVariable("commerceId") int commerceId) {
        return service.getAllByCommerce(commerceId)
                .map(couriers -> new ResponseEntity<>(couriers, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //......................................................................................
    @GetMapping("/email/{email}")
    public ResponseEntity<Courier> getByEmail(@PathVariable("email") String email) {
        return service.getByEmail(email)
                .map(commerce -> new ResponseEntity<>(commerce, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    //......................................................................................
    @ApiOperation("Search a user with an ID")
    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Courier not found"),
    })
    public ResponseEntity<Courier> getById(@ApiParam(value = "The id of the courier", required = true, example = "7")
                                              @PathVariable("id") int id) {
        return service.getCourierById(id)
                .map(courier ->  new ResponseEntity<>(courier, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    //......................................................................................
    @PostMapping()
    public ResponseEntity<Courier> save(@RequestBody Courier dto) {
        return service.save(dto)
                .map(courier ->  new ResponseEntity<>(dto, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    //......................................................................................
    @PatchMapping()
    public ResponseEntity<Courier> update(@RequestBody Courier changes) {
        return service.update(changes)
                .map(courier ->  new ResponseEntity<>(courier, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    //......................................................................................
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id) {
        if (service.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
