package com.cover.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cover.dao.WellDao;
import com.cover.entity.Well;
import com.cover.entity.WellLocation;
import com.cover.entity.WellStatus;
import com.cover.service.WellService;

@Service  //为了包扫描的时候这个Service被扫描到  
public class WellServiceImpl implements WellService{  
    
    @Autowired  
    WellDao wellDao;
	public List<Well> selectAllWell() {
		return wellDao.selectAllWell();
	}
	public WellLocation selectWellByWellNO(Serializable WellNO) {
		return wellDao.selectWellByWellNO(WellNO);
	}
	public void updateWellById(WellStatus well) {
		wellDao.updateWellById(well);
	} 

}