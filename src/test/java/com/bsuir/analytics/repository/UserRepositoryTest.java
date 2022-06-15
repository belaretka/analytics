package com.bsuir.analytics.repository;

import com.bsuir.analytics.model.User;
import com.bsuir.analytics.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {

    @Mock
    UserRepository userRepository;

    User user;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setUsername("user");
        user.setPassword("1234");
    }

    @Test
    public void testGetUser() {

        when(userRepository.findUserByUsername(anyString())).thenReturn(user);
        User userMock = userRepository.findUserByUsername("user");
        Assertions.assertEquals("user", userMock.getUsername());
    }
}
