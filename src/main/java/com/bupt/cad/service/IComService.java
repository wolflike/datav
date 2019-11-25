package com.bupt.cad.service;

import com.alibaba.fastjson.JSONObject;
import com.bupt.cad.entity.Com;
import com.bupt.cad.entity.ComVO;

import java.util.List;

public interface IComService {
    int getNumCom();
    ComVO newCom(JSONObject object);
    ComVO getCom(int comId);
    boolean updateCom(List<Com> list);
}
