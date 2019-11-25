package com.bupt.cad.mapper;


import com.bupt.cad.entity.Com;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ComDao extends BaseDao<Com>{
    int getTotalNum();
    int addCom(Com com);
    List<Com> getAllComById(int screenId);
    Com getCom(int comId);
    int insertComs(@Param("list") List<Com> list);
    int deleteAll(int screenId);
}
