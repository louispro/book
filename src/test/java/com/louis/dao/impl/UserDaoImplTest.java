package com.louis.dao.impl;

import com.louis.bean.User;
import org.junit.Test;

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
        user.setUsername("momonogi");
        user.setPassword("123456");
        user.setEmail("momonogi@louis.com");
        userdao.saveUser(user);
    }
}