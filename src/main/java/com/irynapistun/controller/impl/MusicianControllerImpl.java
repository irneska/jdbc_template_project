package com.irynapistun.controller.impl;

import com.irynapistun.controller.MusicianController;
import com.irynapistun.domain.Musician;
import com.irynapistun.service.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MusicianControllerImpl implements MusicianController {

    @Autowired
    private MusicianService musicianService;

    @Override
    public List<Musician> findAll() {
        return musicianService.findAll();
    }

    @Override
    public Optional<Musician> findById(Integer id) {
        return musicianService.findById(id);
    }

    @Override
    public int create(Musician musician) {
        return musicianService.create(musician);
    }

    @Override
    public int update(Integer id, Musician musician) {
        return musicianService.update(id, musician);
    }

    @Override
    public int delete(Integer id) {
        return musicianService.delete(id);
    }

    @Override
    public Optional<Musician> findByFirstName(String firstName) {
        return musicianService.findByFirstName(firstName);
    }

    @Override
    public Optional<Musician> findByLastName(String lastName) {
        return musicianService.findByLastName(lastName);
    }
}
