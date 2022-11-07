package com.irynapistun.dao;

import com.irynapistun.domain.Musician;

import java.util.Optional;

public interface MusicianDao extends GeneralDao<Musician, Integer> {
    Optional<Musician> findByFirstName(String firstName);

    Optional<Musician> findByLastName(String lastName);
}
