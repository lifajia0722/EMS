package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {

    void addUser(User user);

    String findOneByName(User user);

    void update(User user);
}
