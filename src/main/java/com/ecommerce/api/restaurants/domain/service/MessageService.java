package com.ecommerce.api.restaurants.domain.service;

import com.ecommerce.api.restaurants.domain.dto.Message;
import com.ecommerce.api.restaurants.domain.repository.ParameterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageService {

    @Autowired
    private RestTemplate clienteRest;

    @Autowired
    private ParameterRepository parameterRepository;

    public boolean sentMessage(Message message){
        String key = parameterRepository.findByCode("API.MESSAGE.KEY").get().getValor();
        String uri = parameterRepository.findByCode("API.MESSAGE.URL").get().getValor();
        String url= uri +key+"/t="+message.getNumber()+"&m="+message.getMessage();
        clienteRest.getForObject(url, String.class);
      return  true;
    }


}
