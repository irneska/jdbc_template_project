package com.irynapistun.dao;

import com.irynapistun.domain.Genre;

import java.util.Optional;

public interface GenreDao extends GeneralDao<Genre, Integer> {
    Optional<Genre> findByGenreName(String name);
}
