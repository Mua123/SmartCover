package com.cover.dao;

import java.io.Serializable;
import java.util.List;

import com.cover.entity.Well;
import com.cover.entity.WellLocation;
import com.cover.entity.WellStatus;

public interface WellDao{  
	public List<Well> selectAllWell();
	public WellLocation selectWellByWellNO(Serializable WellNO);
	public void updateWellById(WellStatus well);
}
