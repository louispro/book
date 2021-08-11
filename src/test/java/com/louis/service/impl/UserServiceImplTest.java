package com.louis.service.impl;

import com.louis.bean.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    private UserServiceImpl userService = new UserServiceImpl();

    @Test
    public void register() {
        User user = new User();
        user.setUsername("Karen");
        user.setPassword("123456");
        user.setEmail("Karen@louis.com");
        userService.register(user);
    }

    @Test
    public void login() {
        User user = new User();
        user.setUsername("Karen");
        user.setPassword("123456");
        user.setEmail("Karen@louis.com");
        User user1 = userService.login(user);
        System.out.println(user1);
    }

    @Test
    public void existsUsername() {
        boolean exists = userService.existsUsername("momonogi");
        System.out.println(exists);
    }
}