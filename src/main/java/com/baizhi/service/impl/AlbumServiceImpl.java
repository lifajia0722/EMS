package com.baizhi.service.impl;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;

    @Override
    public void save(Album album) {
        album.setId(UUID.randomUUID().toString());
        albumDao.insert(album);
    }

    @Override
    public void update(Album album) {
        albumDao.update(album);
    }

    @Override
    public void delete(String id) {
        albumDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Album queryOne(String id) {
        return albumDao.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findAll() {
        return albumDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return albumDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return albumDao.queryTotals();
    }

    @Override
    public void deleteAll(String[] ids) {
        albumDao.deleteAll(ids);
    }
}
