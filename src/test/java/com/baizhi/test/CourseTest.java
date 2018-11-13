package com.baizhi.test;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CourseTest {
    @Autowired
    private CourseService courseService;

    @Test
    public void a(){
        List<Course> byPage = courseService.findByPage(2, 1);
        for (Course course:byPage) {
            System.out.println(course);
        }
    }

    @Test
    public void b(){
        Course course=new Course();
        course.setTitle("诚心礼佛");
        course.setFlag("必修");
        course.setCreatTime(new Date());
        courseService.save(course);
    }
}
