package org.example.validateformdangky.service;

import org.example.validateformdangky.model.User;

public interface IUserService extends IGenerateService  {
    Iterable<User> findallByUser(User user);

    void save(User user);
}
