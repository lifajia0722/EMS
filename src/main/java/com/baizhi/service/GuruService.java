package com.baizhi.service;

import com.baizhi.entity.Guru;


import java.util.List;

public interface GuruService {
    void save(Guru guru);
    //修改
    void update(Guru guru);
    //刪除
    void delete(String id);
    //查询单个
    Guru queryOne(String id);
    //查询所有
    List<Guru> findAll();
    //分页
    //参数1:起始条数 //参数2:每页显示的记录数
    List<Guru> findByPage(Integer page, Integer rows);
    //总条数
    Long findTotals();

    //批量删除
    void deleteAll(String[] ids);
}
