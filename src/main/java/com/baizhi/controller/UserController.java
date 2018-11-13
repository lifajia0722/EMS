package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("add")
    public @ResponseBody Map<String,Object> add(User user){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            userService.addUser(user);
            map.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
        }
        return map;

    }

    @RequestMapping("login")
    public @ResponseBody String login(User user){
        String oneByName = userService.findOneByName(user);
        return oneByName;
    }

    @RequestMapping("update")
    public @ResponseBody Map<String,Object> update(User user){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            userService.update(user);
            map.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }
}
