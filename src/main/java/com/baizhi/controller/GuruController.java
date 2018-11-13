package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping("/findPage")
    public @ResponseBody Map<String,Object> findPage(Integer page,Integer rows){
        Map<String, Object> map= new HashMap<>();
        List<Guru> byPage = guruService.findByPage(page, rows);
        Long totals = guruService.findTotals();
        map.put("total",totals);
        map.put("rows",byPage);
        return map;
    }

    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> add(Guru guru, MultipartFile headPic1, HttpServletRequest request){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            String headPic1Name = headPic1.getOriginalFilename();
            guru.setHeadPic("/images/guru/"+headPic1Name);
            String realPath = request.getRealPath("/images/guru/");
            headPic1.transferTo(new File(realPath,headPic1.getOriginalFilename()));
            guruService.save(guru);
            map.put("success",true);
        } catch (IOException e) {
            map.put("success",false);
            e.printStackTrace();
        }
        return map;
    }
    @RequestMapping("/delete")
    public @ResponseBody Map<String,Object> delete(String id,HttpServletRequest request){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            Guru guru = guruService.queryOne(id);
            String realPath = request.getSession().getServletContext().getRealPath(guru.getHeadPic());
            new File(realPath).delete();
            guruService.delete(id);
            map.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }


    @RequestMapping("update")
    public @ResponseBody Map<String,Object> update(Guru guru,MultipartFile headPic1,HttpServletRequest request){
        Map<String,Object> map=new HashMap<String,Object>();
        //获取本来图片路径
        Guru guru1 = guruService.queryOne(guru.getId());
        String realPath = request.getSession().getServletContext().getRealPath(guru1.getHeadPic());
        new File(realPath).delete();
        try {
            String headPic1Name = headPic1.getOriginalFilename();
            guru.setHeadPic("/images/guru/"+headPic1Name);
            String realPath1 = request.getRealPath("/images/guru/");
            headPic1.transferTo(new File(realPath1,headPic1.getOriginalFilename()));
            guruService.update(guru);
            map.put("success",true);
        } catch (Exception e) {
            map.put("success",false);
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("findOne")
    public @ResponseBody Guru findOne(String id){
        return guruService.queryOne(id);
    }
}
