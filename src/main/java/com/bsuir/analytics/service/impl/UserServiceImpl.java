package com.bsuir.analytics.service.impl;

import com.bsuir.analytics.model.User;
import com.bsuir.analytics.repository.UserRepository;
import com.bsuir.analytics.service.MyUserDetails;
import com.bsuir.analytics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {

        if(countAllUsers() == 0)
            user.setRole("ROLE_ADMIN");
        else if(user.getRole() == null)
            user.setRole("ROLE_USER");
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("Нет пользователя с таким логином!");
        return new MyUserDetails(user);
    }

    @Override
    public long countAllUsers() {
        return this.userRepository.count();
    }

}
