package com.irynapistun.dao.impl;

import com.irynapistun.dao.PlaylistDao;
import com.irynapistun.domain.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.Optional;
import java.util.List;

@SuppressWarnings("SqlResolve")
@Service

public class PlaylistDaoImpl implements PlaylistDao {
    private static final String FIND_ALL = "SELECT * FROM playlist";
    private static final String CREATE = "INSERT playlist(number_of_songs) VALUES (?)";
    private static final String UPDATE = "UPDATE playlist SET number_of_songs=? WHERE id=?";
    private static final String DELETE = "DELETE FROM playlist WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM playlist WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Playlist> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Playlist.class));
    }

    @Override
    public Optional<Playlist> findById(Integer id) {
        Optional<Playlist> playlist;
        try {
            playlist = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Playlist.class), id));
        } catch (EmptyResultDataAccessException e) {
            playlist = Optional.empty();
        }
        return playlist;
    }

    @Override
    public int create(Playlist playlist) {
        return jdbcTemplate.update(CREATE, playlist.getNumberOfSongs());
    }

    @Override
    public int update(Integer id, Playlist playlist) {
        return jdbcTemplate.update(UPDATE, playlist.getNumberOfSongs(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
