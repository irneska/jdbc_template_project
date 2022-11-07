package com.irynapistun.dao.impl;

import com.irynapistun.dao.MusicalLabelDao;
import com.irynapistun.domain.MusicalLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.Optional;
import java.util.List;

@SuppressWarnings("SqlResolve")
@Service
public class MusicalLabelDaoImpl implements MusicalLabelDao {
    private static final String FIND_ALL = "SELECT * FROM genre";
    private static final String CREATE = "INSERT musical_lable(name) VALUES (?)";
    private static final String UPDATE = "UPDATE musical_lable SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM musical_lable WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM musical_lable WHERE id=?";
    private static final String FIND_BY_MUSICAL_LABEL_NAME = "SELECT * FROM musical_lable WHERE name=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<MusicalLabel> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(MusicalLabel.class));
    }

    @Override
    public Optional<MusicalLabel> findById(Integer id) {
        Optional<MusicalLabel> musicalLabel;
        try {
            musicalLabel = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(MusicalLabel.class), id));
        } catch (EmptyResultDataAccessException e) {
            musicalLabel = Optional.empty();
        }
        return musicalLabel;
    }

    @Override
    public int create(MusicalLabel musicalLabel) {
        return jdbcTemplate.update(CREATE, musicalLabel.getName());
    }

    @Override
    public int update(Integer id, MusicalLabel musicalLabel) {
        return jdbcTemplate.update(UPDATE, musicalLabel.getName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<MusicalLabel> findByMusicalLabelName(String name) {
        Optional<MusicalLabel> musicalLabel;
        try {
            musicalLabel = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_MUSICAL_LABEL_NAME,
                    BeanPropertyRowMapper.newInstance(MusicalLabel.class), name));
        } catch (EmptyResultDataAccessException e) {
            musicalLabel = Optional.empty();
        }
        return musicalLabel;
    }
}
