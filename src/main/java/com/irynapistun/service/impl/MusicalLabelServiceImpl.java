package com.irynapistun.service.impl;

import com.irynapistun.dao.MusicalLabelDao;
import com.irynapistun.domain.MusicalLabel;
import com.irynapistun.service.MusicalLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MusicalLabelServiceImpl implements MusicalLabelService {

    @Autowired
    private MusicalLabelDao musicalLabelDao;


    @Override
    public List<MusicalLabel> findAll() {
        return musicalLabelDao.findAll();
    }

    @Override
    public Optional<MusicalLabel> findById(Integer id) {
        return musicalLabelDao.findById(id);
    }

    @Override
    public int create(MusicalLabel musicalLabel) {
        return musicalLabelDao.create(musicalLabel);
    }

    @Override
    public int update(Integer id, MusicalLabel musicalLabel) {
        return musicalLabelDao.update(id, musicalLabel);
    }

    @Override
    public int delete(Integer id) {
        return musicalLabelDao.delete(id);
    }

    @Override
    public Optional<MusicalLabel> findByMusicalLabelName(String name) {
        return musicalLabelDao.findByMusicalLabelName(name);
    }
}
