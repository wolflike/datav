package com.bupt.cad.service;

import com.bupt.cad.entity.User;

public interface IUserService {

    boolean login(User user);
    boolean register(User user);
}
