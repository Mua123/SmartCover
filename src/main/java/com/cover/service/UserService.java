package com.cover.service;


import com.cover.entity.User;

	//Service层接口
public interface UserService {
	    //检验用户登录
	   public User checkLogin(String username,String password);
	   public void Regist(User user);
}

