package com.cover.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cover.dao.WellLocationDao;
import com.cover.entity.WellLocation;


@Repository //为了包扫描的时候这个Dao被扫描到  
public class WellLocationDaoImpl extends BaseDaoImpl<WellLocation> implements WellLocationDao{  
    @Autowired  
    //mybatis-spring 1.0无需此方法；mybatis-spring1.2必须注入。  
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){  
        super.setSqlSessionFactory(sqlSessionFactory);  
    }  
    public List<WellLocation> selectAllWell(){
    	 SqlSession sqlSession = this.getSqlSession();
    	 List<WellLocation> well = sqlSession.selectList("well.selectAllWell");
    	 return well;       
    }
    //如果接口UserDao有新的方法定义，在下面就可以实现
	public WellLocation selectWellByWellNO(Serializable WellNO) {
		SqlSession sqlSession = this.getSqlSession();
	        return sqlSession.selectOne("well.selectWellByWellNO",WellNO);
	}
	public void updateWellById(WellLocation well) {
		this.getSqlSession().update("test.updateWellById",well);
	}		
}