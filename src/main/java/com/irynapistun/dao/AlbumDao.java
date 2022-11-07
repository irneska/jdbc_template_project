package com.irynapistun.dao;

import com.irynapistun.domain.Album;

import java.util.Optional;

public interface AlbumDao extends GeneralDao<Album, Integer> {
    Optional<Album> findByAlbumName(String name);
}
