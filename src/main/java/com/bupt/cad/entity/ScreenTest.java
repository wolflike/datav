package com.bupt.cad.entity;

import org.springframework.stereotype.Component;


public class ScreenTest {
    private int userId;
    private String name;
    private String message;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString(){
        return this.message+"-"+this.name+"-"+this.userId+"\n";
    }
}

