package com.bupt.cad.controller;

import com.alibaba.fastjson.JSONObject;
import com.bupt.cad.common.ApiResult;
import com.bupt.cad.entity.ComVO;
import com.bupt.cad.service.impl.ComService;
import com.bupt.cad.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ComController {

    @Autowired
    private ComService comService;
    //创建组件
    @ResponseBody
    @PostMapping(value = "/create/com")
    public ApiResult create(@RequestBody JSONObject jsonObject){

        ComVO comVO = comService.newCom(jsonObject);
        if(comVO!=null){
            return ResultUtil.success(comVO,"create com successfully");
        }
        else{
            return ResultUtil.error(-1,"create com failed");
        }
    }
    //获取组件
    @ResponseBody
    @GetMapping(value = "/get/com")
    public ApiResult get(@RequestParam("comId") int comId){
        ComVO comVO = comService.getCom(comId);
        if(comVO!=null){
            return ResultUtil.success(comVO,"get com successfully");
        }
        else{
            return ResultUtil.error(-1,"get com failed");
        }
    }
    //更新组件
    @ResponseBody
    @PostMapping(value = "/update/com")
    public ApiResult update(@RequestBody JSONObject object){

        return null;
    }
}
