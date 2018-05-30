package com.cover.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.cover.entity.WellLocation;

public interface WellLocationService {    
    public List<WellLocation> selectAllWell();
    public WellLocation selectWellByWellNO(Serializable WellNO);
    public void updateWellById(WellLocation well);
}  