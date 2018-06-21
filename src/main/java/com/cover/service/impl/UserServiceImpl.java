package com.cover.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cover.dao.UserDao;
import com.cover.entity.User;
import com.cover.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    
    /* 
     * 检验用户登录业务
     * 
     */

    public User checkLogin(String username, String password) {
        
        User user = userDao.findByUsername(username);
        if(user != null && user.getPassword().equals(password)){
        System.out.println(password);
            return user;
        }
        return null;
    }

    @Override
    public void Regist(User user) {
    	
        userDao.registerByUsernameAndPassword( user);
        		
    }
}
