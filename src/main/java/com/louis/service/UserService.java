package com.louis.service;

import com.louis.bean.User;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    void register(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 用户名是否存在
     * @param username
     * @return
     */
    boolean existsUsername(String username);
}
