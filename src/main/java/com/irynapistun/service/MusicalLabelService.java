package com.irynapistun.service;

import com.irynapistun.domain.MusicalLabel;

import java.util.Optional;

public interface MusicalLabelService extends GeneralService<MusicalLabel, Integer> {
    Optional<MusicalLabel> findByMusicalLabelName(String name);
}
