package com.louis.dao.impl;

import com.louis.bean.User;
import com.louis.dao.UserDao;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from `user` where `username`=?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String  sql = "SELECT * FROM USER WHERE username=? AND PASSWORD=?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO `user`(`username`,`password`,`email`) VALUES\n" +
                "(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
