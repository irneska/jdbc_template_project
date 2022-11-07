package com.irynapistun.dao.impl;

import com.irynapistun.dao.AlbumDao;
import com.irynapistun.domain.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.Optional;
import java.util.List;

@SuppressWarnings("SqlResolve")
@Service
public class AlbumDaoImpl implements AlbumDao{
    private static final String FIND_ALL = "SELECT * FROM album";
    private static final String CREATE = "INSERT album(name, year_of_publishing, musical_label_id) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE album SET name=?, year_of_publishing=?, musical_label_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM album WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM album WHERE id=?";
    private static final String FIND_BY_ALBUM_NAME = "SELECT * FROM album WHERE name=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Album> findByAlbumName(String name) {
        Optional<Album> album;
        try {
            album = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ALBUM_NAME,
                    BeanPropertyRowMapper.newInstance(Album.class), name));
        } catch (EmptyResultDataAccessException e) {
            album = Optional.empty();
        }
        return album;
    }

    @Override
    public List<Album> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Album.class));
    }

    @Override
    public Optional<Album> findById(Integer id) {
        Optional<Album> album;
        try {
            album = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Album.class), id));
        } catch (EmptyResultDataAccessException e) {
            album = Optional.empty();
        }
        return album;
    }

    @Override
    public int create(Album album) {
        return jdbcTemplate.update(CREATE, album.getName(), album.getYearOfPublishing(), album.getMusicalLabelId());
    }

    @Override
    public int update(Integer id, Album album) {
        return jdbcTemplate.update(UPDATE, album.getName(), album.getYearOfPublishing(), album.getMusicalLabelId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
