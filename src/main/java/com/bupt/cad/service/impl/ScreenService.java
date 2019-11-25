package com.bupt.cad.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bupt.cad.entity.Com;
import com.bupt.cad.entity.Screen;
import com.bupt.cad.entity.ScreenVO;
import com.bupt.cad.mapper.ComDao;
import com.bupt.cad.mapper.ScreenDao;
import com.bupt.cad.service.IScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ScreenService implements IScreenService {

    @Autowired
    private ScreenDao screenDao;

    @Autowired
    private ComDao comDao;
    @Override
    public int selectScreen() {
       return screenDao.getAllScreenNum();
    }

    @Override
    public ScreenVO newScreen(Screen object) {
        int width = 1920;
        int height = 1080;
        String background = "#2e343c";
        boolean isPublic = false;
        JSONObject config = new JSONObject();
        config.put("width",width);
        config.put("height",height);
        config.put("background",background);
        config.put("isPublic",isPublic);
        Screen screen = new Screen();
        ScreenVO screenVO = new ScreenVO();
        screen.setName(object.getName());
        screen.setUserId(object.getUserId());
        screen.setConfig(config);
        if(screenDao.addScreen(screen)!=0){
            JSONObject data = new JSONObject();
            data.put("screenId",screen.getId() );
            screenVO.setConfig(data);
        }
        else{
            screenVO.setConfig(null);
        }
        return screenVO;
    }

    @Override
    public Screen getScreen(int screenId) {
        Screen screen = screenDao.getScreen(screenId);
        List<Com> coms = screen.getComs();
        if(coms.get(0).getId()==0)screen.setComs(new ArrayList<>());
        return screen;
    }

    //保存大屏要做三件事
    //更新大屏参数
    //删除大屏的所有组件
    //插入新组件
    @Override
    public boolean saveScreen(Screen screen) {
        List<Com> coms = screen.getComs();
        for(Com com:coms){
            com.setScreenId(screen.getId());
        }
        if(screenDao.updateScreen(screen)==0)return false;
        comDao.deleteAll(screen.getId());
        if(comDao.insertComs(coms)==0)return false;
        return true;
    }

    @Override
    public List<Screen> getAllScreen(int userId) {
        List<Screen> screens = screenDao.getAllScreen(userId);
        for(Screen screen:screens){
            List<Com> coms = screen.getComs();
            if(coms.get(0).getId()==0)screen.setComs(new ArrayList<>());
        }
        return screens;

    }

    @Override
    public boolean deleteScreen(int screenId) {

        if(screenDao.deleteScreen(screenId)!=0){
            return true;
        }
        else return false;
    }

}
