package com.baizhi.test;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")

public class AlbumTest {
    @Autowired
    private AlbumService albumService;

    @Test
    public void  a(){
        List<Album> byPage = albumService.findAll();
        for(Album album:byPage){
            System.out.println(album);
        }

    }
}
