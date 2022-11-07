package com.irynapistun.service.impl;


import com.irynapistun.domain.Album;
import com.irynapistun.service.AlbumService;

import com.irynapistun.dao.AlbumDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @Override
    public Optional<Album> findByAlbumName(String name) {
        return albumDao.findByAlbumName(name);
    }

    @Override
    public List<Album> findAll() {
        return albumDao.findAll();
    }

    @Override
    public Optional<Album> findById(Integer id) {
        return albumDao.findById(id);
    }

    @Override
    public int create(Album album) {
        return albumDao.create(album);
    }

    @Override
    public int update(Integer id, Album album) {
        return albumDao.update(id, album);
    }

    @Override
    public int delete(Integer id) {
        return albumDao.delete(id);
    }
}
