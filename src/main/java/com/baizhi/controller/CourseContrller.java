package com.baizhi.controller;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Course")
public class CourseContrller {
    @Autowired
    private CourseService courseService;

    @RequestMapping("findPage")
    public @ResponseBody Map<String,Object> findPage(Integer page,Integer rows){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Course> byPage = courseService.findByPage(page, rows);
        Long totals = courseService.findTotals();
        map.put("total",totals);
        map.put("rows",byPage);
        return map;
    }

    @RequestMapping("add")
    public  @ResponseBody Map<String,Object> add(Course course){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            courseService.save(course);
            map.put("success",true);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            return map;
        }
    }

    @RequestMapping("delete")
    public  @ResponseBody Map<String,Object> delete(String id){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            courseService.delete(id);
            map.put("success",true);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            return map;
        }
    }
}
