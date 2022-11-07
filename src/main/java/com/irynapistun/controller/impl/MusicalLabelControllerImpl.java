package com.irynapistun.controller.impl;

import com.irynapistun.controller.MusicalLabelController;
import com.irynapistun.domain.MusicalLabel;
import com.irynapistun.service.MusicalLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MusicalLabelControllerImpl implements MusicalLabelController {
    @Autowired
    private MusicalLabelService musicalLabelService;

    @Override
    public List<MusicalLabel> findAll() {
        return musicalLabelService.findAll();
    }

    @Override
    public Optional<MusicalLabel> findById(Integer id) {
        return musicalLabelService.findById(id);
    }

    @Override
    public int create(MusicalLabel musicalLabel) {
        return musicalLabelService.create(musicalLabel);
    }

    @Override
    public int update(Integer id, MusicalLabel musicalLabel) {
        return musicalLabelService.update(id, musicalLabel);
    }

    @Override
    public int delete(Integer id) {
        return musicalLabelService.delete(id);
    }

    @Override
    public Optional<MusicalLabel> findByMusicalLabelName(String name) {
        return musicalLabelService.findByMusicalLabelName(name);
    }
}
