package com.wzz.wechat.service;

import com.wzz.wechat.entity.Area;

import java.util.List;


public interface AreaService {

    List<Area> getAreaList();

    Area getAreaById(int areaId);

    boolean modifyArea(Area area);

    boolean addArea(Area area);

    boolean deleteArea(int areaId);

}
