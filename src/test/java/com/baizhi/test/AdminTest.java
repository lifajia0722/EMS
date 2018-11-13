package com.baizhi.test;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AdminTest {
    @Autowired
    private AdminService adminService;

    @Test
    public void updateTest(){
         Admin admin = new Admin("1", "张三", "17683894722", "123456");
         adminService.motifyPassword(admin);
    }
}
