package com.ecommerce.api.restaurants.web.controller;


import com.ecommerce.api.restaurants.domain.dto.Commerce;
import com.ecommerce.api.restaurants.domain.dto.CommerceCourier;
import com.ecommerce.api.restaurants.domain.dto.Product;
import com.ecommerce.api.restaurants.domain.dto.TypeCommerce;
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
import java.util.Map;

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
    @ApiOperation("Search a commerce by email")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found"),
    })

    @GetMapping("/email/{email}")
    public ResponseEntity<Commerce> getByEmail(@PathVariable("email") String email) {
        return service.getByEmail(email)
                .map(commerce -> new ResponseEntity<>(commerce, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @ApiOperation("Search a commerce by url")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found"),
    })

    //......................................................................................
    @GetMapping("/url/{url}")
    public ResponseEntity<Commerce> getByUrl(@PathVariable("url") String url ) {
        return service.getByUrl(url)
                .map(commerce -> new ResponseEntity<>(commerce, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    //......................................................................................
    @ApiOperation("Returns shipping cost according to the distance")
    @GetMapping("/{id}/rate/{distance}")
    public ResponseEntity<Integer> getRate(@ApiParam(value = "The id of commerce", required = true, example = "1")
                                           @PathVariable("id") int id,
                                          @ApiParam(value = "shipping distance in Kilometers", required = true, type = "double", example = "1.8")
                                          @PathVariable("distance") double distance  ) {
        return service.getRate(id, distance)
                .map(rate -> new ResponseEntity<>(rate, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/types")
    public ResponseEntity<List<TypeCommerce>> getTypesCommerces() {
        return service. getAllTypeCommerce()
                .map(rate -> new ResponseEntity<>(rate, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/typesActive")
    public ResponseEntity<List<TypeCommerce>> getTypesCommercesActive() {
        return service. getAllTypeCommerceActive()
                .map(rate -> new ResponseEntity<>(rate, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addCourier")
    public ResponseEntity addCourier(@RequestBody CommerceCourier dto) {
        if (service.addCourier(dto)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping()
    public ResponseEntity updateCommerce(@RequestBody Commerce dto) {
        return service.update(dto)
                .map(commerce ->  new ResponseEntity<>(commerce, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

}
