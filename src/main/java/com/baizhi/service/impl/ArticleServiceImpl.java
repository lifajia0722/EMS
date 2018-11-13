package com.baizhi.service.impl;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public void save(Article article) {
        article.setId(UUID.randomUUID().toString());
        articleDao.insert(article);
    }

    @Override
    public void update(Article article) {
        articleDao.update(article);
    }

    @Override
    public void delete(String id) {
        articleDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Article queryOne(String id) {
        return articleDao.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> findAll() {
        return articleDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return articleDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return articleDao.queryTotals();
    }

    @Override
    public void deleteAll(String[] ids) {

    }
}
