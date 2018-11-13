package com.baizhi.service.impl;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Override
    public void save(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        bannerDao.insert(banner);
    }

    @Override
    public void update(Banner banner) {
        bannerDao.update(banner);
    }

    @Override
    public void delete(String id) {
        bannerDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Banner queryOne(String id) {
        return bannerDao.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Banner> findAll() {
        return bannerDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Banner> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return  bannerDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {

        return bannerDao.queryTotals();
    }

    @Override
    public void deleteAll(String[] ids) {
        bannerDao.deleteAll(ids);
    }
}
