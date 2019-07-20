package com.wzz.wechat.controller;

import com.wzz.wechat.entity.Area;
import com.wzz.wechat.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/queryall")
    private Map<String,Object> queryArea(){
        Map<String,Object> modelMap = new HashMap<>();
        List<Area> areaList = areaService.getAreaList();
        modelMap.put("areaList",areaList);
        return modelMap;
    }

    @GetMapping("/queryareabyid")
    private Map<String,Object> queryAreaById(int areaId){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("area",areaService.getAreaById(areaId));
        return modelMap;
    }

    @PostMapping("/addarea")
    private Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }

    @PostMapping("/modifyarea")
    //要求前端传入json数据
    private Map<String,Object> modifyArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",areaService.modifyArea(area));
        return modelMap;
    }

    @GetMapping("deletearea")
    private Map<String,Object> deleteArea(int areaId){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",areaService.deleteArea(areaId));
        return modelMap;
    }

}
