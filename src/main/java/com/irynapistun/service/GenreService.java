package com.irynapistun.service;

import com.irynapistun.domain.Genre;

import java.util.Optional;

public interface GenreService extends GeneralService<Genre, Integer> {
    Optional<Genre> findByGenreName(String name);

}
