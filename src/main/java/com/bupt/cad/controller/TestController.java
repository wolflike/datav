package com.bupt.cad.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bupt.cad.common.ApiResult;
import com.bupt.cad.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class TestController {

    @ResponseBody
    @PostMapping(value = "/hello")
    public User hello(@RequestBody JSONObject object){

        User user = JSONObject.toJavaObject(object,User.class);
        System.out.println(user);

        return user;
    }
}
