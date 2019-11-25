package com.bupt.cad.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bupt.cad.common.ApiResult;
import com.bupt.cad.entity.Com;
import com.bupt.cad.entity.Screen;
import com.bupt.cad.entity.ScreenTest;
import com.bupt.cad.entity.ScreenVO;
import com.bupt.cad.mapper.ComDao;
import com.bupt.cad.service.impl.ComService;
import com.bupt.cad.service.impl.ScreenService;
import com.bupt.cad.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ScreenController {

    @Autowired
    private ScreenService screenService;
    @Autowired
    private ComService comService;

    //得到前端创建大屏的请求
    //应该返回用户要新建的大屏id
    @ResponseBody
    @PostMapping(value = "/create/screen")
    public ApiResult create(@ModelAttribute Screen object){
        ScreenVO screenVO = screenService.newScreen(object);
        if(screenVO!=null){
            return ResultUtil.success(screenVO,"create screen successfully");
        }
        else{
            return ResultUtil.error(-1,"create screen failed");
        }

    }
    //获取大屏
    @ResponseBody
    @GetMapping(value = "/get/screen")
    public ApiResult get(@RequestParam("screenId") int screenId){
        Screen screen = screenService.getScreen(screenId);
        if(screen!=null){
            return ResultUtil.success(screen,"get screen successfully");
        }
        else{
            return ResultUtil.error(-1,"get screen failed");
        }
    }
    //保存
    //保存大屏有两个操作（保存大屏参数和插入组件）
    @ResponseBody
    @PostMapping(value="/save/screen")
    public ApiResult save(@RequestBody Screen screen){
//    public ApiResult save(@RequestBody JSONObject object){
//
//        Screen screen = JSONObject.toJavaObject(object, Screen.class);
        if(screenService.saveScreen(screen)){
            return ResultUtil.success("save screen successfully");
        }
        else{
            return ResultUtil.error(-1,"save screen failed");
        }

    }

    @ResponseBody
    @GetMapping(value = "/getAll/screen")
    public ApiResult getAll(@RequestParam("userId") int userId){
        List<Screen> allScreen = screenService.getAllScreen(userId);
        if(allScreen!=null){
            return ResultUtil.success(allScreen,"get all screen successfully");
        }
        else{
            return ResultUtil.error(-1,"get all screen failed");
        }
    }


    @ResponseBody
    @GetMapping(value = "/delete/screen")
    public ApiResult delete(@RequestParam("screenId") int screenId){
        if(screenService.deleteScreen(screenId)){
            return ResultUtil.success("delete screen successfully");
        }
        else{
            return ResultUtil.error(-1,"delete screen failed");
        }
    }

}
