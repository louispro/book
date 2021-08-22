package com.louis.dao.impl;

import com.louis.bean.User;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    private UserDaoImpl userdao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        User user = userdao.queryUserByUsername("louis");
        System.out.println(user);
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user = userdao.queryUserByUsernameAndPassword("louis","123456");
        System.out.println(user);
    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setUsername("youya");
        user.setPassword("123456");
        user.setEmail("youya@louis.com");
        user.setCartId(UUID.randomUUID().toString());
        userdao.saveUser(user);
    }
}