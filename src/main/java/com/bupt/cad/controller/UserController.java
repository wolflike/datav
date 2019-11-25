package com.bupt.cad.controller;

import com.alibaba.fastjson.JSONObject;
import com.bupt.cad.common.ApiResult;
import com.bupt.cad.entity.User;
import com.bupt.cad.service.impl.UserService;
import com.bupt.cad.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //登录
    @ResponseBody
    @PostMapping(value = "/login")
    public ApiResult login(@RequestBody JSONObject object){
        User user = new User();
        user.setName((String) object.get("username"));
        user.setPassword((String) object.get("password"));
        if(userService.login(user)){
            return ResultUtil.success("login successfully");
        }
        else{
            return ResultUtil.error(-1,"login failed");
        }
    }
    //注册
    @ResponseBody
    @PostMapping(value = "/register")
    public ApiResult register(@RequestBody JSONObject object){
        User user = new User();
        user.setName((String) object.get("username"));
        user.setPassword((String) object.get("password"));

        if(userService.register(user)){
            return ResultUtil.success("register successfully");
        }
        else {
            return ResultUtil.error(-1,"register failed");
        }
    }
}
