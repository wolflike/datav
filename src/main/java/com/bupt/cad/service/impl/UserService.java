package com.bupt.cad.service.impl;

import com.bupt.cad.entity.User;
import com.bupt.cad.mapper.UserDao;
import com.bupt.cad.service.IUserService;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;


@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean login(User user) {//用户不提供用户id
        List<User> users = userDao.getAllUser();
        Iterator<User> it = users.iterator();
        System.out.println(it.hasNext());
        while (it.hasNext()){
            User user1 = it.next();
            if(user1.getName().equals(user.getName())
                    && user1.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean register(User user) {

        List<User> users = userDao.getAllUser();
        Iterator<User> it = users.iterator();
        while (it.hasNext()){
            if(it.next().getName()==user.getName()){
                return false;
            }
        }
        //插入数据库
        int num = userDao.getAllUserNum();
        user.setId(num+1);
        if(userDao.insertUser(user)!=1)return false;
        return true;
    }
}
