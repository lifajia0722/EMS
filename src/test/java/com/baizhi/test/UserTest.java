package com.baizhi.test;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void a(){
        User user=new User();
        user.setPhoneNum("123");
        user.setUsername("11");
        user.setPassword("123");
        userService.addUser(user);
    }

    @Test
    public void a1(){
        User user=new User();
        user.setPhoneNum("123");
        user.setPassword("20");
        String oneByName = userService.findOneByName(user);
        System.out.println(oneByName);
    }

    @Test
    public void a2(){
        User user=new User();
        user.setId("f36a790b-9282-4c50-8a2d-c54d4437d65e");
        user.setPhoneNum("123");
        user.setPassword("20");
        userService.update(user);
    }
}
