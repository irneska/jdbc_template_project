package com.irynapistun.service;

import com.irynapistun.domain.Album;
import com.irynapistun.domain.User;

import java.util.Optional;

public interface UserService extends GeneralService<User, Integer> {
    Optional<User> findByFirstName(String firstName);

    Optional<User> findByLastName(String lastName);
}
