package com.cover.dao;

import java.io.Serializable;
import java.util.List;

import com.cover.entity.WellLocation;

public interface WellLocationDao{  
	public List<WellLocation> selectAllWell();
	public WellLocation selectWellByWellNO(Serializable WellNO);
	public void updateWellById(WellLocation well);
}
