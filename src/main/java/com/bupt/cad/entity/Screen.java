package com.bupt.cad.entity;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public class Screen {
    private int id;
    private String name;
    private int userId;
    private Map<String,Object> config;
    private List<Com> coms;
    private String createTimestamp;
    private String updateTimestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Map<String, Object> getConfig() {
        return config;
    }

    public void setConfig(Map<String, Object> config) {
        this.config = config;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(String updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public List<Com> getComs() {
        return coms;
    }

    public void setComs(List<Com> coms) {
        this.coms = coms;
    }

    @Override
    public String toString() {

        String result="";
        result+="id:"+id+"\n";
        result+="name:"+name+"\n";
        result+="userId:"+userId+"\n";
        result+="config:"+config+"\n";
        return result;
    }
}
