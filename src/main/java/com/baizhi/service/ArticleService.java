package com.baizhi.service;

import com.baizhi.entity.Article;


import java.util.List;

public interface ArticleService {
    void save(Article article);
    //修改
    void update(Article article);
    //刪除
    void delete(String id);
    //查询单个
    Article queryOne(String id);
    //查询所有
    List<Article> findAll();
    //分页
    //参数1:起始条数 //参数2:每页显示的记录数
    List<Article> findByPage(Integer page,Integer rows);
    //总条数
    Long findTotals();

    //批量删除
    void deleteAll(String[] ids);
}
