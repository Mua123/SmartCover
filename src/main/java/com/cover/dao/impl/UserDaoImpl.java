package com.cover.dao.impl;

import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cover.dao.UserDao;
import com.cover.entity.User;
import com.cover.entity.Well;
import com.cover.mapper.UserMapper;

@Repository("userDao")
public  class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	 @Autowired  
	    //mybatis-spring 1.0无需此方法；mybatis-spring1.2必须注入。  
	    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){  
	        super.setSqlSessionFactory(sqlSessionFactory);  
	    }  
	
	@Override
	public User findByUsername(String username) {
		SqlSession sqlSession = this.getSqlSession();
        return sqlSession.selectOne("findByUsername",username);
	}

	@Override
	public void registerByUsernameAndPassword(User user) {
		// TODO Auto-generated method stub
	    this.getSqlSession().insert("com.cover.dao.UserDao.registerByUsernameAndPassword",user);
		System.out.println(user+"huhuhuhuhuhuhuhuh");
	}
}