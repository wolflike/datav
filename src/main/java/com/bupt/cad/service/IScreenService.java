package com.bupt.cad.service;

import com.alibaba.fastjson.JSONObject;
import com.bupt.cad.entity.Screen;
import com.bupt.cad.entity.ScreenVO;

import java.util.List;
import java.util.Map;

public interface IScreenService {
    int selectScreen();
    ScreenVO newScreen(Screen object);
    Screen getScreen(int screenId);
    boolean saveScreen(Screen screen);
    List<Screen> getAllScreen(int userId);
    boolean deleteScreen(int screenId);
}
