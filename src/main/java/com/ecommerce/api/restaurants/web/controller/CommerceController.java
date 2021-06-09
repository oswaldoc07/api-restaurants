package com.ecommerce.api.restaurants.web.controller;


import com.ecommerce.api.restaurants.domain.dto.Commerce;
import com.ecommerce.api.restaurants.domain.service.CommerceService;

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
@RequestMapping("/commerces")
public class CommerceController {

    @Autowired
    private CommerceService service;

    //......................................................................................
    @ApiOperation("Get all commerces")
    @GetMapping()
    public ResponseEntity<List<Commerce>> getAll() {
        return service.getAll()
                .map(commerces -> new ResponseEntity<>(commerces, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //......................................................................................
    @ApiOperation("Get all commerces by category")
    @GetMapping("category/{categoryId}")
    public ResponseEntity<List<Commerce>> getAllbyCategory(
            @ApiParam(value = "The id of the category", required = true, example = "2")
            @PathVariable("categoryId") int categoryId) {
        return service.getAllByCategory(categoryId)
                .map(commerces -> new ResponseEntity<>(commerces, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    //......................................................................................
    @GetMapping("/{id}")
    @ApiOperation("Search a commerce with an ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found"),
    })
    public ResponseEntity<Commerce> getUserById(@ApiParam(value = "The id of the product", required = true, example = "7")
                                                    @PathVariable("id") int userId) {
        return service.getById(userId)
                .map(user ->  new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //......................................................................................
    @GetMapping("/email/{email}")
    public ResponseEntity<Commerce> getByEmail(@PathVariable("email") String email) {
        return service.getByEmail(email)
                .map(commerce -> new ResponseEntity<>(commerce, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //......................................................................................
    @GetMapping("/url/{url}")
    public ResponseEntity<Commerce> getByUrl(@PathVariable("url") String url ) {
        return service.getByUrl(url)
                .map(commerce -> new ResponseEntity<>(commerce, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    //......................................................................................
    @GetMapping("/{id}/rate/{distance}")
    public ResponseEntity<Integer> getRate(@PathVariable("id") int id,
                                          @PathVariable("distance") double distance  ) {
        return service.getRate(id, distance)
                .map(rate -> new ResponseEntity<>(rate, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
