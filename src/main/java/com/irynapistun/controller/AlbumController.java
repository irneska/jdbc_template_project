package com.irynapistun.controller;

import com.irynapistun.domain.Album;

import java.util.Optional;

public interface AlbumController extends GeneralController<Album, Integer> {
    Optional<Album> findByAlbumName(String name);
}
