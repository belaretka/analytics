package com.bsuir.analytics.service;

import com.bsuir.analytics.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(long id);
    User getUserByName(String name);
    void deleteUserById(long id);
    long countAllUsers();
}
