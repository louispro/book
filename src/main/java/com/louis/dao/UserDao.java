package com.louis.dao;

import com.louis.bean.User;
import com.louis.dao.impl.BaseDao;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public interface UserDao{
    User queryUserByUsername(String username);

    User queryUserByUsernameAndPassword(String username,String password);

    int saveUser(User user);
}
