package com.irynapistun.controller.impl;

import com.irynapistun.controller.UserController;
import com.irynapistun.domain.User;
import com.irynapistun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userService.findById(id);
    }

    @Override
    public int create(User user) {
        return userService.create(user);
    }

    @Override
    public int update(Integer id, User user) {
        return userService.update(id, user);
    }

    @Override
    public int delete(Integer id) {
        return userService.delete(id);
    }

    @Override
    public Optional<User> findByFirstName(String firstName) {
        return userService.findByFirstName(firstName);
    }

    @Override
    public Optional<User> findByLastName(String lastName) {
        return userService.findByLastName(lastName);
    }
}
