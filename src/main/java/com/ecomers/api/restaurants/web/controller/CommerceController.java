package com.ecomers.api.restaurants.web.controller;

import com.ecomers.api.restaurants.domain.dto.Client;;
import com.ecomers.api.restaurants.domain.dto.Commerce;
import com.ecomers.api.restaurants.domain.dto.User;
import com.ecomers.api.restaurants.domain.service.ClientService;
import com.ecomers.api.restaurants.domain.service.CommerceService;
import com.ecomers.api.restaurants.domain.service.MessageService;
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
    @GetMapping("/{id}")
    @ApiOperation("Search a user with an ID")
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



}
