package com.cover.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cover.entity.User;


public interface UserDao {
    
    
    /**
     * 查找用户名和密码
     * @param username 登录用户名 
     * @return
     */
public  User findByUsername(String username);
    /**
     * 注册用户和密码
     */
public void registerByUsernameAndPassword(User user);
	
}

