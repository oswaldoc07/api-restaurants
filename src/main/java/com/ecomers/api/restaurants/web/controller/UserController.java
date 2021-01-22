package com.ecomers.api.restaurants.web.controller;

import com.ecomers.api.restaurants.domain.dto.Product;
import com.ecomers.api.restaurants.domain.dto.User;
import com.ecomers.api.restaurants.domain.repository.UserRepository;
import com.ecomers.api.restaurants.domain.service.UserService;
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
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    @ApiOperation("Search a user with an ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found"),
    })
    public ResponseEntity<User> getUserById(@ApiParam(value = "The id of the product", required = true, example = "7")
                                              @PathVariable("id") int userId) {
        return service.getUserById(userId)
                .map(product ->  new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{email}/{phone}")
    public ResponseEntity<User> getUserByEmailOrPhone(@PathVariable("email") String email, @PathVariable("phone") String phone ) {
        return service.getUserByEmailOrPhone(email,phone)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User dto) {
        return service.save(dto)
                .map(user ->  new ResponseEntity<>(user, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PatchMapping()
    public ResponseEntity<User> update(@RequestBody User changes) {
        return service.update(changes)
                .map(user ->  new ResponseEntity<>(user, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId) {
        if (service.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
