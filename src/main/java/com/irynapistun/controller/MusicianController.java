package com.irynapistun.controller;

import com.irynapistun.domain.Musician;

import java.util.Optional;

public interface MusicianController extends GeneralController<Musician, Integer> {
    Optional<Musician> findByFirstName(String firstName);

    Optional<Musician> findByLastName(String lastName);
}
