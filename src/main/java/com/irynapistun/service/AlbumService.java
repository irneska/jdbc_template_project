package com.irynapistun.service;

import com.irynapistun.domain.Album;

import java.util.Optional;

public interface AlbumService extends GeneralService<Album, Integer> {
    Optional<Album> findByAlbumName(String name);
}
