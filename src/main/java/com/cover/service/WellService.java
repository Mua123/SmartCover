package com.cover.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.cover.entity.Well;

public interface WellService {    
    public List<Well> selectAllWell();
    public Well selectWellByorderON(Serializable orderON);
    public void updateWellById(Well well);
}  