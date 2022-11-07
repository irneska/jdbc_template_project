package com.irynapistun.service.impl;

import com.irynapistun.dao.UserDao;
import com.irynapistun.domain.User;
import com.irynapistun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public int create(User user) {
        return userDao.create(user);
    }

    @Override
    public int update(Integer id, User user) {
        return userDao.update(id, user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public Optional<User> findByFirstName(String firstName) {
        return userDao.findByFirstName(firstName);
    }

    @Override
    public Optional<User> findByLastName(String lastName) {
        return userDao.findByLastName(lastName);
    }
}
