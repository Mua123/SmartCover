package com.cover.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.cover.entity.Well;
import com.cover.entity.WellLocation;
import com.cover.entity.WellStatus;

public interface WellService {    
    public List<Well> selectAllWell();
    public WellLocation selectWellByWellNO(Serializable WellNO);
    public void updateWellById(WellStatus well);
    public void saveWell(WellLocation well);
    public List<Well> selectWellByStatus(Well well);
	public List<Well> insert(int upstatus, int downstatus, int vibratingstatus);
}  