package org.example.validateformdangky.service;


import org.example.validateformdangky.model.User;
import org.example.validateformdangky.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findallByUser(User user) {
        return null;
    }

    @Override
    public Iterable findAll() {
        return null;
    }

    @Override
    public void save(User user) {
        I

    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {

    }
}
