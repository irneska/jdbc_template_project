package com.irynapistun.service.impl;

import com.irynapistun.dao.MusicianDao;
import com.irynapistun.domain.Musician;
import com.irynapistun.service.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MusicianServiceImpl implements MusicianService {
    @Autowired
    private MusicianDao musicianDao;


    @Override
    public List<Musician> findAll() {
        return musicianDao.findAll();
    }

    @Override
    public Optional<Musician> findById(Integer id) {
        return musicianDao.findById(id);
    }

    @Override
    public int create(Musician musician) {
        return musicianDao.create(musician);
    }

    @Override
    public int update(Integer id, Musician musician) {
        return musicianDao.update(id, musician);
    }

    @Override
    public int delete(Integer id) {
        return musicianDao.delete(id);
    }

    @Override
    public Optional<Musician> findByFirstName(String firstName) {
        return musicianDao.findByFirstName(firstName);
    }

    @Override
    public Optional<Musician> findByLastName(String lastName) {
        return musicianDao.findByLastName(lastName);
    }
}
