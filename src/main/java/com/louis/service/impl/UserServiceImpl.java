package com.louis.service.impl;

import com.louis.bean.Cart;
import com.louis.bean.User;
import com.louis.dao.impl.UserDaoImpl;
import com.louis.service.UserService;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao = new UserDaoImpl();
    private CartServiceImpl cartService = new CartServiceImpl();

    @Override
    public void register(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            return false;
        }
        return true;
    }

    /**
     * 获取购物车
     * @param cartId
     * @return
     */
    @Override
    public Cart getCart(String cartId) {
        return cartService.initCart(cartId);
    }
}
