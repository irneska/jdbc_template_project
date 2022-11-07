package com.irynapistun.service.impl;

import com.irynapistun.dao.GenreDao;
import com.irynapistun.domain.Genre;
import com.irynapistun.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreDao genreDao;


    @Override
    public List<Genre> findAll() {
        return genreDao.findAll();
    }

    @Override
    public Optional<Genre> findById(Integer id) {
        return genreDao.findById(id);
    }

    @Override
    public int create(Genre genre) {
        return genreDao.create(genre);
    }

    @Override
    public int update(Integer id, Genre genre) {
        return genreDao.update(id, genre);
    }

    @Override
    public int delete(Integer id) {
        return genreDao.delete(id);
    }

    @Override
    public Optional<Genre> findByGenreName(String name) {
        return genreDao.findByGenreName(name);
    }
}
