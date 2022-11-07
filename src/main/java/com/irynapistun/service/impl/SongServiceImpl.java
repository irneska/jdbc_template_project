package com.irynapistun.service.impl;

import com.irynapistun.dao.SongDao;
import com.irynapistun.domain.Song;
import com.irynapistun.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SongServiceImpl implements SongService {

    @Autowired
    private SongDao songDao;


    @Override
    public List<Song> findAll() {
        return songDao.findAll();
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return songDao.findById(id);
    }

    @Override
    public int create(Song song) {
        return songDao.create(song);
    }

    @Override
    public int update(Integer id, Song song) {
        return songDao.update(id, song);
    }

    @Override
    public int delete(Integer id) {
        return songDao.delete(id);
    }

    @Override
    public Optional<Song> findBySongName(String name) {
        return songDao.findBySongName(name);
    }
}
