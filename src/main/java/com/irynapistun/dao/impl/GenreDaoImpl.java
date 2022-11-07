package com.irynapistun.dao.impl;

import com.irynapistun.dao.GenreDao;
import com.irynapistun.domain.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.Optional;
import java.util.List;

@SuppressWarnings("SqlResolve")
@Service

public class GenreDaoImpl implements GenreDao {
    private static final String FIND_ALL = "SELECT * FROM genre";
    private static final String CREATE = "INSERT genre(name) VALUES (?)";
    private static final String UPDATE = "UPDATE genre SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM genre WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM genre WHERE id=?";
    private static final String FIND_BY_GENRE_NAME = "SELECT * FROM genre WHERE name=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Genre> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Genre.class));
    }

    @Override
    public Optional<Genre> findById(Integer id) {
        Optional<Genre> genre;
        try {
            genre = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Genre.class), id));
        } catch (EmptyResultDataAccessException e) {
            genre = Optional.empty();
        }
        return genre;
    }

    @Override
    public int create(Genre genre) {
        return jdbcTemplate.update(CREATE, genre.getName());
    }

    @Override
    public int update(Integer id, Genre genre) {
        return jdbcTemplate.update(UPDATE, genre.getName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Genre> findByGenreName(String name) {
        Optional<Genre> genre;
        try {
            genre = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_GENRE_NAME,
                    BeanPropertyRowMapper.newInstance(Genre.class), name));
        } catch (EmptyResultDataAccessException e) {
            genre = Optional.empty();
        }
        return genre;
    }
}
