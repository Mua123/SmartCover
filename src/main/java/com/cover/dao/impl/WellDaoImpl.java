package com.cover.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cover.dao.WellDao;
import com.cover.entity.Well;


@Repository //为了包扫描的时候这个Dao被扫描到  
public class WellDaoImpl extends BaseDaoImpl<Well> implements WellDao{  
    @Autowired  
    //mybatis-spring 1.0无需此方法；mybatis-spring1.2必须注入。  
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){  
        super.setSqlSessionFactory(sqlSessionFactory);  
    }  
    public List<Well> selectAllWell(){
    	 SqlSession sqlSession = this.getSqlSession();
    	 List<Well> well = sqlSession.selectList("test.selectAllWell");
    	 return well;
       
    }
    //如果接口UserDao有新的方法定义，在下面就可以实现
	public Well selectWellByorderON(Serializable orderON) {
		SqlSession sqlSession = this.getSqlSession();
	        return sqlSession.selectOne("test.selectWellByorderON",orderON);
	}
	public void updateWellById(Well well) {
		this.getSqlSession().update("test.updateWellById",well);
	}
		
}