package com.irynapistun.dao;

import com.irynapistun.domain.User;

import java.util.Optional;

public interface UserDao extends GeneralDao<User, Integer> {
    Optional<User> findByFirstName(String firstName);

    Optional<User> findByLastName(String lastName);
}
