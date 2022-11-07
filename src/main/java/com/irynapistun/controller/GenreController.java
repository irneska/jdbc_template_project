package com.irynapistun.controller;

import com.irynapistun.domain.Genre;

import java.util.Optional;

public interface GenreController extends GeneralController<Genre, Integer> {
    Optional<Genre> findByGenreName(String name);
}
