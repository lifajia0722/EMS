package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao extends BaseDao<User>{
    User queryOneByName(User user);
}
