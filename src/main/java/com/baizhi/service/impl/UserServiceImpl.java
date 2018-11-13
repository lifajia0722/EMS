package com.baizhi.service.impl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.SaltUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        //获取盐值
        String salt = SaltUtils.getSalt(4);
        //获取用户输入的密码
        String password = user.getPassword();
        //加密用户输入的密码
        String s = DigestUtils.md5Hex(salt + password);
        //把加密后的密码存入user对象中
        user.setPassword(s);
        //UUID
        user.setId(UUID.randomUUID().toString());
        //盐值存入user对象中
        user.setSalt(salt);
        //调userDao的插入方法把user对象传过去
        userDao.insert(user);
    }

    @Override
    public String findOneByName(User user) {
        //根据用户输入的账号查询
        User user1 = userDao.queryOneByName(user);
        //判断查询结果是否为空，为空返回100
        //100表示账号有误
        //200表示登录成功
        //300表示密码有误
        if(user1==null){
            return "100";
        }
        else if(DigestUtils.md5Hex(user1.getSalt() + user.getPassword()).equals(user1.getPassword())){
            return "200";
        }else {
            return "300";
        }

    }

    @Override
    public void update(User user) {
        User user1 = userDao.queryOneByName(user);
        user.setPassword(DigestUtils.md5Hex(user1.getSalt()+user.getPassword()));
        userDao.update(user);
    }
}
