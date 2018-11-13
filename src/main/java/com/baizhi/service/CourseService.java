package com.baizhi.service;

import com.baizhi.entity.Course;

import java.util.List;

public interface CourseService {

    void save(Course course);
    //修改
    void update(Course course);
    //刪除
    void delete(String id);
    //查询单个
    Course queryOne(String id);
    //查询所有
    List<Course> findAll();
    //分页
    //参数1:起始条数 //参数2:每页显示的记录数
    List<Course> findByPage(Integer page,Integer rows);
    //总条数
    Long findTotals();

    //批量删除
    void deleteAll(String[] ids);

}
