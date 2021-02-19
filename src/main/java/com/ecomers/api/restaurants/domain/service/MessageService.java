package com.ecomers.api.restaurants.domain.service;

import com.ecomers.api.restaurants.domain.dto.Message;
import com.ecomers.api.restaurants.domain.dto.Parameter;
import com.ecomers.api.restaurants.domain.repository.ParameterRepository;
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
        String key = parameterRepository.findByCode("MESSAGE.KEY").get().getValor();
        String uri = parameterRepository.findByCode("MESSAGE.URL").get().getValor();
        String url= uri +key+"/t="+message.getNumber()+"&m="+message.getMessage();
        String result = clienteRest.getForObject(url, String.class);
      return  true;
    }


}
