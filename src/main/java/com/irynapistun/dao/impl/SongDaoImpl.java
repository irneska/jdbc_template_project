package com.irynapistun.dao.impl;

import com.irynapistun.dao.SongDao;
import com.irynapistun.domain.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.Optional;
import java.util.List;

@SuppressWarnings("SqlResolve")
@Service
public class SongDaoImpl implements SongDao {
    private static final String FIND_ALL = "SELECT * FROM song";
    private static final String CREATE = "INSERT song(name, duration, album_id, genre_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE song SET name=?, duration=?, album_id=?, genre_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM song WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM song WHERE id=?";
    private static final String FIND_BY_SONG_NAME = "SELECT * FROM song WHERE name=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Song> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Song.class));
    }

    @Override
    public Optional<Song> findById(Integer id) {
        Optional<Song> song;
        try {
            song = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Song.class), id));
        } catch (EmptyResultDataAccessException e) {
            song = Optional.empty();
        }
        return song;
    }

    @Override
    public int create(Song song) {
        return jdbcTemplate.update(CREATE, song.getName(), song.getDuration(), song.getAlbumId(), song.getGenreId());
    }

    @Override
    public int update(Integer id, Song song) {
        return jdbcTemplate.update(UPDATE, song.getName(), song.getDuration(), song.getAlbumId(), song.getGenreId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Song> findBySongName(String name) {
        Optional<Song> song;
        try {
            song = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_SONG_NAME,
                    BeanPropertyRowMapper.newInstance(Song.class), name));
        } catch (EmptyResultDataAccessException e) {
            song = Optional.empty();
        }
        return song;
    }
}
