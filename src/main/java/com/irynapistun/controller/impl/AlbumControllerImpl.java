package com.irynapistun.controller.impl;

import com.irynapistun.controller.AlbumController;
import com.irynapistun.domain.Album;
import com.irynapistun.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AlbumControllerImpl implements AlbumController {
    @Autowired
    private AlbumService albumService;


    @Override
    public Optional<Album> findByAlbumName(String name) {
        return albumService.findByAlbumName(name);
    }

    @Override
    public List<Album> findAll() {
        return albumService.findAll();
    }

    @Override
    public Optional<Album> findById(Integer id) {
        return albumService.findById(id);
    }

    @Override
    public int create(Album album) {
        return albumService.create(album);
    }

    @Override
    public int update(Integer id, Album album) {
        return albumService.update(id, album);
    }

    @Override
    public int delete(Integer id) {
        return albumService.delete(id);
    }
}
