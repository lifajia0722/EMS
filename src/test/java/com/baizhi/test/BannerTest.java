package com.baizhi.test;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class BannerTest {
    @Autowired
    private BannerService bannerService;

    @Test
    public void findpega(){
        List<Banner> byPage = bannerService.findByPage(2, 2);
        for(Banner banner:byPage){
            System.out.println(banner);
        }



    }

}
