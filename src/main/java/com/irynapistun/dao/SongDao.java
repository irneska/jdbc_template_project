package com.irynapistun.dao;

import com.irynapistun.domain.Song;

import java.util.Optional;

public interface SongDao extends GeneralDao<Song, Integer> {
    Optional<Song> findBySongName(String name);
}
