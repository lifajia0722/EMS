package com.baizhi.service.impl;

import com.baizhi.dao.CourseDao;
import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public void save(Course course) {
        course.setId(UUID.randomUUID().toString());
        courseDao.insert(course);
    }

    @Override
    public void update(Course course) {
    }

    @Override
    public void delete(String id) {
        courseDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Course queryOne(String id) {
        return courseDao.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Course> findAll() {
        return courseDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Course> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return courseDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return courseDao.queryTotals();
    }

    @Override
    public void deleteAll(String[] ids) {
    }
}
