package com.ecomers.api.restaurants.persistence.dao;

import com.ecomers.api.restaurants.domain.dto.Product;
import com.ecomers.api.restaurants.domain.dto.User;
import com.ecomers.api.restaurants.domain.repository.UserRepository;
import com.ecomers.api.restaurants.persistence.crud.ProductoCrudRepository;
import com.ecomers.api.restaurants.persistence.crud.UsuarioCrudRepository;
import com.ecomers.api.restaurants.persistence.entity.Producto;
import com.ecomers.api.restaurants.persistence.entity.Usuario;
import com.ecomers.api.restaurants.persistence.mapper.ProductMapper;
import com.ecomers.api.restaurants.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository crudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getAll() {
        List<Usuario> entities = (List<Usuario>) crudRepository.findAll();
        return mapper.toUsers(entities);
    }



    @Override
    public Optional<User> getUserById(int productId) {
        return crudRepository.findById(productId).map(usuario -> mapper.toUser(usuario));

    }

    @Override
    public Optional<User> getUserByEmail(String email) {
       return crudRepository.findByCorreoElectronico(email).map(producto -> mapper.toUser(producto));
    }

    @Override
    public Optional<User> getUserByPhone(String phone) {
        return crudRepository.findByCelular(phone).map(producto -> mapper.toUser(producto));
    }

    @Override
    public  Optional<User> save(User dto) {
        Usuario usuario = mapper.toUsuario(dto);
        return Optional.of(mapper.toUser(crudRepository.save(usuario)));
    }

    @Override
    public Optional<User>  update(User changes) {
        User user=  crudRepository.findById(changes.getId()).map(usuario -> mapper.toUser(usuario)).get();
        user.setEmail(changes.getEmail());
        user.setPhoneNumber(changes.getPhoneNumber());
        Usuario usuario = mapper.toUsuario(user);
        return Optional.of(mapper.toUser(crudRepository.save(usuario)));
    }

    @Override
    public void delete(int id) {
        this.crudRepository.deleteById(id);
    }
}
