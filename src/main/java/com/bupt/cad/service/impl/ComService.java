package com.bupt.cad.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bupt.cad.entity.Com;
import com.bupt.cad.entity.ComVO;
import com.bupt.cad.mapper.ComDao;
import com.bupt.cad.service.IComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ComService implements IComService {
    @Autowired
    private ComDao comDao;
    @Override
    public int getNumCom() {
        return comDao.getTotalNum();
    }
    @Override
    public ComVO newCom(JSONObject jsonObject){
        JSONObject config= new JSONObject();
        Com com = JSONObject.toJavaObject(jsonObject, Com.class);
        ComVO comVO = new ComVO();
        if(comDao.addCom(com)!=0){//插入数据库是否成功
            JSONObject data = new JSONObject();
//            data.put("comId",num+1);
            comVO.setConfig(data);
        }else{
            comVO.setConfig(null);
        }
        return comVO;
    }

    @Override
    public ComVO getCom(int comId) {
        Com com = comDao.getCom(comId);
        ComVO comVO = new ComVO();
        if(com!=null){
            JSONObject data = new JSONObject();
            data.put("config",com.getConfig());
            comVO.setConfig(data);
        }
        else{
            comVO.setConfig(null);
        }
        return comVO;
    }

    @Override
    public boolean updateCom(List<Com> list) {

        int i = comDao.insertComs(list);
        if(i!=0){
            return true;
        }
        return false;
    }

}
