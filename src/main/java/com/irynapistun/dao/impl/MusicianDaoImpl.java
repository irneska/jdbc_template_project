package com.irynapistun.dao.impl;

import com.irynapistun.dao.MusicianDao;
import com.irynapistun.domain.Musician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.Optional;
import java.util.List;

@SuppressWarnings("SqlResolve")
@Service

public class MusicianDaoImpl implements MusicianDao {
    private static final String FIND_ALL = "SELECT * FROM musician";
    private static final String CREATE = "INSERT musician(first_name, last_name, album_id) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE musician SET first_name=?, last_name=?, album_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM musician WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM musician WHERE id=?";
    private static final String FIND_BY_FIRST_NAME = "SELECT * FROM musician WHERE first_name=?";
    private static final String FIND_BY_LAST_NAME = "SELECT * FROM musician WHERE last_name=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Musician> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Musician.class));
    }

    @Override
    public Optional<Musician> findById(Integer id) {
        Optional<Musician> musician;
        try {
            musician = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Musician.class), id));
        } catch (EmptyResultDataAccessException e) {
            musician = Optional.empty();
        }
        return musician;
    }

    @Override
    public int create(Musician musician) {
        return jdbcTemplate.update(CREATE, musician.getFirstName(), musician.getLastName(), musician.getAlbumId());
    }

    @Override
    public int update(Integer id, Musician musician) {
        return jdbcTemplate.update(UPDATE, musician.getFirstName(), musician.getLastName(), musician.getAlbumId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Musician> findByFirstName(String firstName) {
        Optional<Musician> musician;
        try {
            musician = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_FIRST_NAME,
                    BeanPropertyRowMapper.newInstance(Musician.class), firstName));
        } catch (EmptyResultDataAccessException e) {
            musician = Optional.empty();
        }
        return musician;
    }

    @Override
    public Optional<Musician> findByLastName(String lastName) {
        Optional<Musician> musician;
        try {
            musician = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_LAST_NAME,
                    BeanPropertyRowMapper.newInstance(Musician.class), lastName));
        } catch (EmptyResultDataAccessException e) {
            musician = Optional.empty();
        }
        return musician;
    }
}
