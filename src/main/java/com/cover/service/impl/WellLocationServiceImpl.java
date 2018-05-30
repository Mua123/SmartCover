package com.cover.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cover.dao.WellLocationDao;
import com.cover.entity.WellLocation;
import com.cover.service.WellLocationService;

@Service  //为了包扫描的时候这个Service被扫描到  
public class WellLocationServiceImpl implements WellLocationService{  
    
    @Autowired  
    WellLocationDao welllocationDao;
	public List<WellLocation> selectAllWell() {
		return welllocationDao.selectAllWell();
	}
	public WellLocation selectWellByWellNO(Serializable WellNO) {
		return welllocationDao.selectWellByWellNO(WellNO);
	}
	public void updateWellById(WellLocation well) {
		welllocationDao.updateWellById(well);
	} 

}