package com.irynapistun.dao.impl;

import com.irynapistun.dao.UserDao;
import com.irynapistun.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.Optional;
import java.util.List;

@SuppressWarnings("SqlResolve")
@Service

public class UserDaoImpl implements UserDao {
    private static final String FIND_ALL = "SELECT * FROM user";
    private static final String CREATE = "INSERT user(first_name, last_name, playlist_id) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE user SET first_name=?, last_name=?, playlist_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM user WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM user WHERE id=?";
    private static final String FIND_BY_FIRST_NAME = "SELECT * FROM user WHERE first_name=?";
    private static final String FIND_BY_LAST_NAME = "SELECT * FROM user WHERE last_name=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public Optional<User> findById(Integer id) {
        Optional<User> user;
        try {
            user = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(User.class), id));
        } catch (EmptyResultDataAccessException e) {
            user = Optional.empty();
        }
        return user;
    }

    @Override
    public int create(User user) {
        return jdbcTemplate.update(CREATE, user.getFirstName(), user.getLastName(), user.getPlaylistId());
    }

    @Override
    public int update(Integer id, User user) {
        return jdbcTemplate.update(UPDATE, user.getFirstName(), user.getLastName(), user.getPlaylistId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<User> findByFirstName(String firstName) {
        Optional<User> user;
        try {
            user = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_FIRST_NAME,
                    BeanPropertyRowMapper.newInstance(User.class), firstName));
        } catch (EmptyResultDataAccessException e) {
            user = Optional.empty();
        }
        return user;
    }

    @Override
    public Optional<User> findByLastName(String lastName) {
        Optional<User> user;
        try {
            user = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_LAST_NAME,
                    BeanPropertyRowMapper.newInstance(User.class), lastName));
        } catch (EmptyResultDataAccessException e) {
            user = Optional.empty();
        }
        return user;
    }
}
