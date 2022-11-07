package com.irynapistun.controller;

import com.irynapistun.domain.Song;

import java.util.Optional;

public interface SongController extends GeneralController<Song, Integer> {
    Optional<Song> findBySongName(String name);
}
