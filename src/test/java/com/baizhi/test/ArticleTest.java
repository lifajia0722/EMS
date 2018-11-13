package com.baizhi.test;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ArticleTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void a(){
//        List<Article> all = articleService.findByPage(1,1);
        Long totals = articleService.findTotals();
        System.out.println(totals);

    }
}
