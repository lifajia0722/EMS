package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    void save(Album Album);
    //修改
    void update(Album Album);
    //刪除
    void delete(String id);
    //查询单个
    Album queryOne(String id);
    //查询所有
    List<Album> findAll();
    //分页
    //参数1:起始条数 //参数2:每页显示的记录数
    List<Album> findByPage(Integer page, Integer rows);
    //总条数
    Long findTotals();

    //批量删除
    void deleteAll(String[] ids);
}
