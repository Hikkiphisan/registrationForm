package org.example.validateformdangky.service;

import org.example.validateformdangky.model.User;

public interface IUserService<User> extends IGenerateService<User>  {
    Iterable<User> findallByUser(User user);

}
