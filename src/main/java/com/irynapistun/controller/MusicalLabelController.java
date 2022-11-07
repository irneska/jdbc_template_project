package com.irynapistun.controller;

import com.irynapistun.domain.MusicalLabel;

import java.util.Optional;

public interface MusicalLabelController extends GeneralController<MusicalLabel, Integer> {
    Optional<MusicalLabel> findByMusicalLabelName(String name);

}
