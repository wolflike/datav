package com.bupt.cad.mapper;


import com.bupt.cad.entity.Screen;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ScreenDao extends BaseDao<Screen>{
    int getAllScreenNum();
    int addScreen(Screen screen);
    Screen getScreen(int screenId);
    int updateScreen(Screen screen);
    List<Screen> getAllScreen(int userId);
    int deleteScreen(int screenId);
}
