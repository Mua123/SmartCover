package com.cover.dao;

import java.io.Serializable;
import java.util.List;

import com.cover.entity.Well;

public interface WellDao{  
	public List<Well> selectAllWell();
	public Well selectWellByorderON(Serializable orderON);
	public void updateWellById(Well well);
}
