package com.irynapistun.service;

import com.irynapistun.domain.Song;

import java.util.Optional;

public interface SongService extends GeneralService<Song, Integer> {
    Optional<Song> findBySongName(String name);
}
