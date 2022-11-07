package com.irynapistun.controller.impl;

import com.irynapistun.controller.GenreController;
import com.irynapistun.domain.Genre;
import com.irynapistun.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GenreControllerImpl implements GenreController {

    @Autowired
    private GenreService genreService;

    @Override
    public List<Genre> findAll() {
        return genreService.findAll();
    }

    @Override
    public Optional<Genre> findById(Integer id) {
        return genreService.findById(id);
    }

    @Override
    public int create(Genre genre) {
        return genreService.create(genre);
    }

    @Override
    public int update(Integer id, Genre genre) {
        return genreService.update(id, genre);
    }

    @Override
    public int delete(Integer id) {
        return genreService.delete(id);
    }

    @Override
    public Optional<Genre> findByGenreName(String name) {
        return genreService.findByGenreName(name);
    }
}
