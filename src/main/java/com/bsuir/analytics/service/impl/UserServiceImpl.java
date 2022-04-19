package com.bsuir.analytics.service.impl;

import com.bsuir.analytics.model.User;
import com.bsuir.analytics.repository.UserRepository;
import com.bsuir.analytics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if(optional.isPresent())
            user = optional.get();
        else
            throw new RuntimeException("User not found");
        return user;

    }

    @Override
    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User getUserByName(String name) {
        userRepository.findUserByUsername(name);
        return null;
    }
}
