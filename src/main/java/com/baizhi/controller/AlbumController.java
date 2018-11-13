package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import com.baizhi.util.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAll(){
        Map<String, Object> map= new HashMap<>();
        List<Album> byPage = albumService.findAll();
        //Long totals = albumService.findTotals();
        map.put("total",byPage.size());
        map.put("rows",byPage);
        return map;
    }

    /*@RequestMapping("/findAll1")
    public @ResponseBody List<Album> findAll(){
        return albumService.findAll();
    }*/

    @RequestMapping("/findOne")
    public @ResponseBody Album findOne(String id){
        return albumService.queryOne(id);
    }

    @RequestMapping("add")
    public @ResponseBody Map<String,Object> add(Album album, HttpServletRequest request,MultipartFile coverImg1){
        Map<String, Object> map= new HashMap<>();
        try {
            String uploading = UploadUtils.uploading(request, coverImg1, "/images/album/");
            album.setCoverImg(uploading);
            albumService.save(album);
            map.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }
}
