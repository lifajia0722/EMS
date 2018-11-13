package com.baizhi.service.impl;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceimpl implements GuruService {

    @Autowired
    private GuruDao guruDao;

    @Override
    public void save(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruDao.insert(guru);
    }

    @Override
    public void update(Guru guru) {
        guruDao.update(guru);
    }

    @Override
    public void delete(String id) {
        guruDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Guru queryOne(String id) {
        return guruDao.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Guru> findAll() {
        return guruDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Guru> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return guruDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return guruDao.queryTotals();
    }

    @Override
    public void deleteAll(String[] ids) {
        guruDao.deleteAll(ids);
    }
}
