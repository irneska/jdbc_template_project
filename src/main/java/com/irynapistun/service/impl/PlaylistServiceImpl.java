package com.irynapistun.service.impl;

import com.irynapistun.dao.PlaylistDao;
import com.irynapistun.domain.Playlist;
import com.irynapistun.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private  PlaylistDao playlistDao;


    @Override
    public List<Playlist> findAll() {
        return playlistDao.findAll();
    }

    @Override
    public Optional<Playlist> findById(Integer id) {
        return playlistDao.findById(id);
    }

    @Override
    public int create(Playlist playlist) {
        return playlistDao.create(playlist);
    }

    @Override
    public int update(Integer id, Playlist playlist) {
        return playlistDao.update(id, playlist);
    }

    @Override
    public int delete(Integer id) {
        return playlistDao.delete(id);
    }
}
