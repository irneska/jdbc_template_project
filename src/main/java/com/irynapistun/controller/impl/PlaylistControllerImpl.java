package com.irynapistun.controller.impl;

import com.irynapistun.controller.PlaylistController;
import com.irynapistun.domain.Playlist;
import com.irynapistun.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PlaylistControllerImpl implements PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @Override
    public List<Playlist> findAll() {
        return playlistService.findAll();
    }

    @Override
    public Optional<Playlist> findById(Integer id) {
        return playlistService.findById(id);
    }

    @Override
    public int create(Playlist playlist) {
        return playlistService.create(playlist);
    }

    @Override
    public int update(Integer id, Playlist playlist) {
        return playlistService.update(id, playlist);
    }

    @Override
    public int delete(Integer id) {
        return playlistService.delete(id);
    }
}
