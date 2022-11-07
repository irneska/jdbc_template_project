package com.irynapistun.controller.impl;

import com.irynapistun.controller.SongController;
import com.irynapistun.domain.Song;
import com.irynapistun.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SongControllerImpl implements SongController {

    @Autowired
    private SongService songService;

    @Override
    public List<Song> findAll() {
        return songService.findAll();
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return songService.findById(id);
    }

    @Override
    public int create(Song song) {
        return songService.create(song);
    }

    @Override
    public int update(Integer id, Song song) {
        return songService.update(id, song);
    }

    @Override
    public int delete(Integer id) {
        return songService.delete(id);
    }

    @Override
    public Optional<Song> findBySongName(String name) {
        return songService.findBySongName(name);
    }
}
