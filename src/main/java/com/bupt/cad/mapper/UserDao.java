package com.bupt.cad.mapper;

import com.bupt.cad.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao extends BaseDao<User>{

    List<User> getAllUser();
    //插入user对象
    int insertUser(User user);
    User findUserById(int id);
    int getAllUserNum();

}
