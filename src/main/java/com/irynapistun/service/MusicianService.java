package com.irynapistun.service;

import com.irynapistun.domain.Musician;

import java.util.Optional;

public interface MusicianService extends GeneralService<Musician, Integer> {
    Optional<Musician> findByFirstName(String firstName);

    Optional<Musician> findByLastName(String lastName);
}
