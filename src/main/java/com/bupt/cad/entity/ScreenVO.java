package com.bupt.cad.entity;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class ScreenVO {
    private Map<String,Object> config;

    public Map<String, Object> getConfig() {
        return config;
    }

    public void setConfig(Map<String, Object> config) {
        this.config = config;
    }
}
