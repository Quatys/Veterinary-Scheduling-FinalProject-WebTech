package com.example.veterinaryproject.service;

import com.example.veterinaryproject.model.User;

public interface UserService {
    void saveUser(User user);

    User findByUsername(String username);
}
