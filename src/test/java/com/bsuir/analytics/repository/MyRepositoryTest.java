package com.bsuir.analytics.repository;

import com.bsuir.analytics.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class MyRepositoryTest {

    private UserRepository userRepository;

    @Autowired
    MyRepositoryTest(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @BeforeEach
    void initUseCase() {
        List<User> users = Arrays.asList(
                new User("tanja", "123456")
        );

        userRepository.saveAll(users);
    }

    @AfterEach
    public void destroyAll(){
        userRepository.deleteAll();
    }

    @Test
    public void saveAll_success() {
        List<User> users = Arrays.asList(
                new User("tanja","123456"),
                new User("gerry", "123456"),
                new User("kerry", "123456")

        );
        Iterable<User> allUsers = userRepository.saveAll(users);

        AtomicInteger validIdFound = new AtomicInteger();
        allUsers.forEach(user -> {
            if(user.getUsername()!=null){
                validIdFound.getAndIncrement();
            }
        });

        Assert.assertEquals(validIdFound.intValue(),users.size());
    }

    @Test
    public void findAll_success() {
        List<User> allUsers = userRepository.findAll();
        Assert.assertTrue(allUsers.size()>(1));
    }
}
