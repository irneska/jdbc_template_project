package com.irynapistun.dao;

import com.irynapistun.domain.MusicalLabel;

import java.util.Optional;

public interface MusicalLabelDao extends GeneralDao<MusicalLabel, Integer> {
    Optional<MusicalLabel> findByMusicalLabelName(String name);
}
