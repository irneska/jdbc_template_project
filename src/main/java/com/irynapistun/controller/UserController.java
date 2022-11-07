package com.irynapistun.controller;

import com.irynapistun.domain.User;

import java.util.Optional;

public interface UserController extends GeneralController<User, Integer> {
    Optional<User> findByFirstName(String firstName);

    Optional<User> findByLastName(String lastName);
}
