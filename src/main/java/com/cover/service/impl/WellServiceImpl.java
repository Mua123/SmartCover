package com.cover.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cover.dao.WellDao;
import com.cover.entity.Well;
import com.cover.service.WellService;

@Service  //为了包扫描的时候这个Service被扫描到  
public class WellServiceImpl implements WellService{  
    
    @Autowired  
    WellDao wellDao;
	public List<Well> selectAllWell() {
		return wellDao.selectAllWell();
	}
	public Well selectWellByorderON(Serializable orderON) {
		return wellDao.selectWellByorderON(orderON);
	}
	public void updateWellById(Well well) {
		wellDao.updateWellById(well);
	} 

}
