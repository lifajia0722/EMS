package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    void save(Banner banner);
    //修改
    void update(Banner banner);
    //刪除
    void delete(String id);
    //查询单个
    Banner queryOne(String id);
    //查询所有
    List<Banner> findAll();
    //分页
    //参数1:起始条数 //参数2:每页显示的记录数
    List<Banner> findByPage(Integer page,Integer rows);
    //总条数
    Long findTotals();

    //批量删除
    void deleteAll(String[] ids);
}
